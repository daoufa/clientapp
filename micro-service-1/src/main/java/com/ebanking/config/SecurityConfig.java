package com.ebanking.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username as principal,password as credentials,active from users where username=?")
		.authoritiesByUsernameQuery("select username as pricipale, role as role from users_roles where username=?")
		.rolePrefix("ROLE_").passwordEncoder(bCryptPasswordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		
		.antMatchers(HttpMethod.GET,"/clients/**/**","/compteEpargnes/**",
				"/compteCourants/**","/comptes/**/**","/compteEpargnes/**")
		
		.access("hasRole('ROLE_CLIENT')")
		
		//les roles agents
		.antMatchers(HttpMethod.POST,"/clients/**/**","/compteEpargnes/**","/compteCourants/**","/comptes/**","/compteEpargnes/**")
		.access("hasRole('ROLE_AGENT')")
		
		//les roles client en lecture
		
		
		//les roles admin ou client
		.antMatchers("/virements/**","/saveVirements/**",
						"/rechargeTelephones/**","/saveRecharge/**")
		.access("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
		
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

		//http.authorizeRequests().anyRequest().permitAll();
	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

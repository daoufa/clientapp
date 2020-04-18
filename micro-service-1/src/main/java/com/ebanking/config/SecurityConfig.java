package com.ebanking.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		http.formLogin();
//		http.authorizeRequests().antMatchers("/users/**").hasRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		
	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

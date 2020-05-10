package com.ebanking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ebanking.model.Client;
import com.ebanking.model.Compte;
import com.ebanking.model.CompteCourant;
import com.ebanking.model.CompteEpargne;
import com.ebanking.model.Operation;
import com.ebanking.model.Role;
import com.ebanking.model.User;
import com.ebanking.repository.ClientRepository;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.RoleRepository;
import com.ebanking.repository.UserRepository;
import com.ebanking.service.IBanqueService;
import com.ebanking.service.IClientService;

@SpringBootApplication
@EnableAutoConfiguration
public class MicroService1Application implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private IClientService iClientService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Client.class);
		repositoryRestConfiguration.exposeIdsFor(Operation.class);
		repositoryRestConfiguration.exposeIdsFor(Compte.class);
		BCryptPasswordEncoder bcp=new BCryptPasswordEncoder();
		Client client=new Client("elatrouz", "ahmed", "aelatrouz@gmailcom","0632302864","homme");
		clientRepository.save(client);
		compteRepository.save(new CompteEpargne( new Date(), 100.0, client, 0.1));
		compteRepository.save(new CompteCourant( new Date(), 15000.0, client, 0.3));
		//Compte compte=iClientService.consulterCompte(1l);
		//Compte compte2=iClientService.consulterCompte(2l);
		//System.out.println(compte);
		//iClientService.virement(compte.getNumCompte(),compte2.getNumCompte(), 12.0);
		//iClientService.rechargeTelephone(compte.getNumCompte(), "0632302864", 20.0);
		
		Role role1=new Role();
		role1.setRole("ADMIN");
		
		Role role2=new Role();
		role2.setRole("USER");
		
		roleRepository.save(role1);
		roleRepository.save(role2);
		User user1=new User();
		user1.setUsername("client1");user1.setPassword(bcp.encode("000"));user1.setActive(true);
		user1.addRole(role2);
		userRepository.save(user1);
		
		/*User user2=new User();
		user2.setUsername("admin");user2.setPassword(bcp.encode("123"));user2.setActive(true);
		user2.addRole(role1);user2.addRole(role2);
		userRepository.save(user2);*/
	}

}

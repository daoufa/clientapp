package com.ebanking;

import java.util.Collection;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ebanking.model.Admin;
import com.ebanking.model.Agence;
import com.ebanking.model.Agent;
import com.ebanking.model.Client;
import com.ebanking.model.Compte;
import com.ebanking.model.CompteCourant;
import com.ebanking.model.CompteEpargne;
import com.ebanking.model.RechargeTelephone;
import com.ebanking.model.Role;
import com.ebanking.model.User;
import com.ebanking.model.Virement;
import com.ebanking.repository.AdminRepository;
import com.ebanking.repository.AgenceRepository;
import com.ebanking.repository.AgentRepository;
import com.ebanking.repository.ClientRepository;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.RoleRepository;
import com.ebanking.repository.UserRepository;
import com.ebanking.repository.VirementRepository;
import com.ebanking.service.IAdminService;
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
	private IAdminService iAdminService;
	
	@Autowired 
	private AgentRepository agentRepository;
	@Autowired
	private AgenceRepository agenceRepository;
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private VirementRepository virementRepository;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Client.class);
		repositoryRestConfiguration.exposeIdsFor(Compte.class);
		repositoryRestConfiguration.exposeIdsFor(CompteCourant.class);
		repositoryRestConfiguration.exposeIdsFor(CompteEpargne.class);

		repositoryRestConfiguration.exposeIdsFor(RechargeTelephone.class);

		repositoryRestConfiguration.exposeIdsFor(Virement.class);
		adminRepository.save(new Admin("dafali", "youssef", "heisenberg", "123456"));
		BCryptPasswordEncoder bcp=new BCryptPasswordEncoder();
		Client client=new Client("elatrouz", "ahmed", "aelatrouz@gmailcom","0632302864","homme");
		Client client2=new Client("dafali", "youssef", "dafali@email.com","0693220509","homme");
		Client client3=new Client("Daoufa", "abderahman", "daufa@email.com","066666666","homme");
		Client client4=new Client("Tazi", "Karima", "tazi@email.com","0555555555","femme");
		
		clientRepository.save(client);
		clientRepository.save(client2);
		clientRepository.save(client3);
		clientRepository.save(client4);
		compteRepository.save(new CompteEpargne( new Date(), 100.0, client, 0.1));
		compteRepository.save(new CompteCourant( new Date(), 15000.0, client, 0.3));

		Compte c1=compteRepository.findById(2l).orElse(null);
		Compte c2=compteRepository.findById(1l).orElse(null);
		Virement virement=new Virement(c1, c2, 3500.00);
		virementRepository.save(virement);

		compteRepository.save(new CompteEpargne( new Date(), 150.0, client2, 0.9));
		compteRepository.save(new CompteCourant( new Date(), 20000.0, client2, 0.5));

		Compte compte=iClientService.consulterCompte(1l);
		Compte compte2=iClientService.consulterCompte(2l);
		//System.out.println(compte);
		iClientService.virement(compte.getNumCompte(),compte2.getNumCompte(), 12.0);
		iClientService.rechargeTelephone(compte.getNumCompte(), "0632302864", 20.0);
		
		
		Agence agence = agenceRepository.save(new Agence("ebank", "rue M6"));
		Agence agence2 = agenceRepository.save(new Agence("ebank2", "rue M5")); 
		Agent ag1 = agentRepository.save(new Agent("jane", "patric", agence));
		Agent ag2 = agentRepository.save(new Agent("tribiani", "joe", agence2));
		Agent ag3 = agentRepository.save(new Agent("bing", "chandler", agence2));
		
		//iAdminService.changeAgence(agence, ag3);
		
		
		Role role1=new Role();
		role1.setRole("ADMIN");
		
		Role role2=new Role();
		role2.setRole("USER");
		
		roleRepository.save(role1);
		roleRepository.save(role2);
		User user1=new User();
		user1.setUsername("client1");
		user1.setPassword(bcp.encode("000"));
		user1.setActive(true);
		user1.addRole(role2);
		userRepository.save(user1);
		
		User user2=new User();
		user2.setUsername("admin");
		user2.setPassword(bcp.encode("123"));
		user2.setActive(true);
		user2.addRole(role1);user2.addRole(role2);
		userRepository.save(user2);
	}

}

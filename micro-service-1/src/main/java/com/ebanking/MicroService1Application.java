package com.ebanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.ebanking.config.GlobalParam;
import com.ebanking.model.Agent;
import com.ebanking.model.Client;
import com.ebanking.model.Compte;
import com.ebanking.model.CompteCourant;
import com.ebanking.model.CompteEpargne;
import com.ebanking.model.RechargeTelephone;
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
import com.ebanking.service.IClientService;
import com.ebanking.service.IUserService;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(GlobalParam.class)
public class MicroService1Application implements CommandLineRunner {

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
	private IUserService iUserService;

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
		repositoryRestConfiguration.exposeIdsFor(Agent.class);

		repositoryRestConfiguration.exposeIdsFor(RechargeTelephone.class);

		repositoryRestConfiguration.exposeIdsFor(Virement.class);
		// adminRepository.save(new Admin("dafali", "youssef", "heisenberg", "123456"));
		/*
		 * adminRepository.save(new Admin("dafali", "youssef", "heisenberg", "123456"));
		 * BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
		 * 
		 * Client client = new Client("Elatrouz", "ahmed", "elatrouz@email.com",
		 * "0698785645", "homme", false, "22/12/1998", "marocain", "maroc", "etudiant",
		 * "etudiant", "EE8888", "marrakech", "", ""); Client client2 = new
		 * Client("Dafai", "youssef", "elatrouz@email.com", "000000000", "homme", false,
		 * "22/12/1998", "marocain", "maroc", "etudiant", "etudiant", "FF7777",
		 * "marrakech", "", ""); Client client3 = new Client("khalid", "hamza",
		 * "khalid@email.com", "0698785645", "homme", false, "02/02/1992", "marocain",
		 * "maroc", "ingenieur", "ingenieur", "EE9999", "casa", "", ""); Client client4
		 * = new Client("Tazi", "sara", "tazi@email.com", "05555555", "femme", false,
		 * "22/12/1998", "marocain", "maroc", "medecine", "medecine", "EE8888",
		 * "marrakech", "", "");
		 * 
		 * clientRepository.save(client); clientRepository.save(client2);
		 * clientRepository.save(client3); clientRepository.save(client4);
		 * compteRepository.save(new CompteEpargne(new Date(), 100.0, client, 0.1));
		 * compteRepository.save(new CompteCourant(new Date(), 15000.0, client, 0.3));
		 * Compte c1 = compteRepository.findById(2l).orElse(null); Compte c2 =
		 * compteRepository.findById(1l).orElse(null); compteRepository.save(new
		 * CompteEpargne(new Date(), 150.0, client2, 0.9)); compteRepository.save(new
		 * CompteCourant(new Date(), 20000.0, client2, 0.5)); Compte compte =
		 * iClientService.consulterCompte(1l); Compte compte2 =
		 * iClientService.consulterCompte(2l);
		 * 
		 * // iClientService.virement(compte.getNumCompte(), compte2.getNumCompte(),
		 * 12.0); // iClientService.rechargeTelephone(compte.getNumCompte(),
		 * "0632302864", 20.0);
		 * 
		 * Agence agence = agenceRepository.save(new Agence("ebank", "rue M6", "Casa"));
		 * Agence agence2 = agenceRepository.save(new Agence("ebank2", "rue M5",
		 * "Marrakech")); Agence agence3 = agenceRepository.save(new Agence("ebank3",
		 * "rue salam", "tanger")); agentRepository .save(new Agent("Anik", "Habib",
		 * "maroc", "casa", "065987456", "habib@email.com", "ff5689", agence));
		 * agentRepository .save(new Agent("Tribiani", "Joe", "maroc", "tanger",
		 * "060606060", "joe@email.com", "gg546", agence)); agentRepository.save( new
		 * Agent("Bing", "cChandler", "maroc", "marrakech", "065987456",
		 * "bing@email.com", "hh5445", agence2));
		 * 
		 * // iAdminService.changeAgence(agence, ag3);
		 * 
		 */
		// iUserService.saveUser(new User("agent1", "123456",null,
		// agentRepository.findById(1l).orElse(null), null, false, null));
		// iUserService.saveUser(new User("admin", "123456", true, null));
		// iUserService.saveRole(new Role("ADMIN", null)); iUserService.saveRole(new
		// Role("CLIENT", null));

//		iUserService.addRoleToUser("agent1", "CLIENT");
		// iUserService.addRoleToUser("admin", "CLIENT");
		// iUserService.addRoleToUser("client1", "CLIENT");

	}

}

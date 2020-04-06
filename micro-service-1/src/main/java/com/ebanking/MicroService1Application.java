package com.ebanking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ebanking.model.Client;
import com.ebanking.model.Compte;
import com.ebanking.model.CompteCourant;
import com.ebanking.model.CompteEpargne;
import com.ebanking.repository.ClientRepository;
import com.ebanking.repository.CompteRepository;
import com.ebanking.service.IBanqueService;

@SpringBootApplication
@EnableAutoConfiguration
public class MicroService1Application implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private IBanqueService iBanqueService;
	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client client=new Client("elatrouz", "ahmed", "aelatrouz@gmailcom","0632302864","homme");
		clientRepository.save(client);
		compteRepository.save(new CompteEpargne( new Date(), 100.0, client, 0.1));
		compteRepository.save(new CompteCourant( new Date(), 15000.0, client, 0.3));
		Compte compte=iBanqueService.consulterCompte(1l);
		System.out.println(compte);
		iBanqueService.verser(compte.getNumCompte(), 123456.0);
		
	}

}

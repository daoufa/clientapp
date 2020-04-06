package com.ebanking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ebanking.model.Client;
import com.ebanking.model.CompteEpargne;
import com.ebanking.repository.ClientRepository;
import com.ebanking.repository.CompteRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class MicroService1Application implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client client=new Client("elatrouz", "ahmed", "aelatrouz@gmailcom","0632302864","homme");
		clientRepository.save(client);
		compteRepository.save(new CompteEpargne(15000l, new Date(), 100.0, client, 0.1) );
		
		
	}

}

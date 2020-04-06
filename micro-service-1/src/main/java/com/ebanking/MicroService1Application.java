package com.ebanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ebanking.model.Client;
import com.ebanking.repository.ClientRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class MicroService1Application /*implements CommandLineRunner*/{

	@Autowired
	private ClientRepository clientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		//clientRepository.save(new Client(null, "ahmed", "ahmed", "ahmed@email.com", "0606060606", "homme", 21, "123456"));
		
		
	}*/

}

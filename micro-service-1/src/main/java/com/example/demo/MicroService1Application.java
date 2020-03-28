package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroService1Application implements CommandLineRunner {

	@Autowired
	private  ClientRepository clientRepository;
	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		clientRepository.save(new Client(null, "ahmed"));
		
	}
	

}

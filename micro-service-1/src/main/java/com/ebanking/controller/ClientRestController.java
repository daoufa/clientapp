package com.ebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Client;
import com.ebanking.repository.ClientRepository;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.OperationRepository;

@RestController
public class ClientRestController {


	@Autowired
	private ClientRepository clientRepository; 

	@PostMapping (value ="/saveClient",consumes = "application/json", produces = "application/json")
    public Client save(@RequestBody Client c) {
		return clientRepository.save(c);
	}
	
}

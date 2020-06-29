package com.ebanking.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Client;
import com.ebanking.repository.ClientRepository;
import com.ebanking.repository.CompteRepository;

@RestController
@CrossOrigin("*")
public class ClientRestController {


	@Autowired
	private ClientRepository clientRepository; 

	@PostMapping (value ="/saveClient",consumes = "application/json", produces = "application/json")
    public Client save(@RequestBody Client c) {
		return clientRepository.save(c);
	}
	
	@PutMapping(value="/saveClient/{id}",consumes = "application/json", produces = "application/json")
	public Client update(@PathVariable(name="id") Long id,@RequestBody Client c){
		c.setCode(id);
		return clientRepository.save(c);
	}
	
	
}

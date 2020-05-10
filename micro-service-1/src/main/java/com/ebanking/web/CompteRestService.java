package com.ebanking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Compte;
import com.ebanking.service.ClientServiceImpl;
import com.ebanking.service.IClientService;

@RestController
public class CompteRestService {
	
	@Autowired
	private ClientServiceImpl iClientService;
	
	@GetMapping(value = "/listComptes/{numCpt}" )
	public Compte oneComptes(@PathVariable(name ="numCpt") Long numCpt){
		return iClientService.consulterCompte(numCpt);
	}

}

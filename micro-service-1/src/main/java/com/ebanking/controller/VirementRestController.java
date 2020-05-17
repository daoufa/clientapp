package com.ebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Client;
import com.ebanking.model.Compte;
import com.ebanking.model.Virement;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.VirementRepository;

@RestController
public class VirementRestController {

	@Autowired
	private VirementRepository virementRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	/*@PostMapping (value ="/virements",consumes = "application/json", produces = "application/json")
    public Virement save(@RequestBody Virement v) {
		Compte compte=compteRepository.findById(v.getCompte().getNumCompte()).orElse(null);
		v.setCompte(compte);
		return virementRepository.save(v);
	}
	*/
	

}

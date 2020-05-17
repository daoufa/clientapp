package com.ebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Compte;
import com.ebanking.model.RechargeTelephone;
import com.ebanking.model.Virement;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.RechargeTelephoneRepository;
import com.ebanking.repository.VirementRepository;

@RestController
public class RechargeTelephoneRestController {

	@Autowired
	private RechargeTelephoneRepository rechargeTelephoneRepository;
	@Autowired
	private CompteRepository compteRepository ;
	
	@GetMapping (value="/RechargeTelephone/compte/{id}")
	public List<RechargeTelephone> getRechargeTelephoneByCompte(@PathVariable(name="id") Long id){
		Compte compte = compteRepository.findByNumCompte(id);
		 return rechargeTelephoneRepository.findByCompte(compte);
	}
	
	

}

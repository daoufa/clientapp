package com.ebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ebanking.model.Virement;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.VirementRepository;
import com.ebanking.service.IClientService;

@RestController
@CrossOrigin("*")
public class VirementRestController {

	@Autowired
	private VirementRepository virementRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private IClientService iClientService;
	
	
	
	@PostMapping (value ="/saveVirements")
    public Virement save(@RequestBody Virement v) {
		iClientService.virement(v.getCompteId(),v.getDestCompteId(),v.getMontant());
		return virementRepository.save(v);
	}
	
	

}

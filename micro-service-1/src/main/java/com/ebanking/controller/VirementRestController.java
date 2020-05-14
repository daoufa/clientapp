package com.ebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ebanking.model.Virement;
import com.ebanking.repository.VirementRepository;

@RestController
public class VirementRestController {

	@Autowired
	private VirementRepository virementRepository;
	
	
	

}

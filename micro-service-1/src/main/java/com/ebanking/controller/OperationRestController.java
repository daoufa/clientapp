package com.ebanking.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Compte;
import com.ebanking.model.CompteEpargne;
import com.ebanking.model.Operation;
import com.ebanking.model.RechargeTelephone;
import com.ebanking.model.Virement;
import com.ebanking.repository.OperationRepository;

@RestController
public class OperationRestController {

	
	@Autowired
	private OperationRepository OperationRepository;
	
	@GetMapping (value="/virements")
	public List<Operation> getVirements(){
		return OperationRepository.findByIsVirement(true);
	}
	
	@GetMapping (value="/recharges")
	public List<Operation> getRecharges(){
		return OperationRepository.findByIsVirement(false);
	}
	
	
	@GetMapping (value="/virements/{id}")
	public Operation getVirementById(@PathVariable(name="id") Long id){
		
		return OperationRepository.findByNumeroAndIsVirement(id, true);
	}
	
	
	@GetMapping (value="/recharges/{id}")
	public Operation getRechargeById(@PathVariable(name="id") Long id){
		
		return OperationRepository.findByNumeroAndIsVirement(id, false);
	}
	
	@PostMapping (value="/virements",consumes = "application/json", produces = "application/json")
	public Operation saveVirements(@RequestBody Operation v){
		v.setVirement(true);
		return OperationRepository.save(v);
	}
	
	@PostMapping (value="/recharges",consumes = "application/json", produces = "application/json")
	public Operation saveRecharges(@RequestBody RechargeTelephone r){
		r.setVirement(false);
		return OperationRepository.save(r);
	}
}

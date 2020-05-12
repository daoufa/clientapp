package com.ebanking.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Client;
import com.ebanking.model.Compte;
import com.ebanking.model.CompteCourant;
import com.ebanking.model.CompteEpargne;
import com.ebanking.repository.ClientRepository;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.OperationRepository;

@RestController
public class CompteRestController {

	
	@Autowired
	private CompteRepository compteRepository;
	
	@GetMapping (value="/compteEpargnes")
	public List<Compte> getCompteEpargnes(){
		return compteRepository.findByIsEpargne(true);
	}
	
	
	@GetMapping (value="/compteEpargnes/{id}")
	public Compte getCompteEpargneById(@PathVariable(name="id") Long id){
		
		return compteRepository.findByNumCompteAndIsEpargne(id, true);
	}
	
	
	@GetMapping (value="/compteCourants")
	public List<Compte> getCompteCourants(){
		 return compteRepository.findByIsEpargne(false);
	}
	
	
	@GetMapping (value="/compteCourants/{id}")
	public Compte getCompteCourantById(@PathVariable(name="id") Long id){
		 return compteRepository.findByNumCompteAndIsEpargne(id, false);
	}
	
	@PostMapping (value="/compteCourants",consumes = "application/json", produces = "application/json")
	public Compte saveCompteCourant(@RequestBody CompteCourant c){
		c.setEpargne(true);
		return compteRepository.save(c);
		
		
	}
	
	@PostMapping (value="/compteEpargnes",consumes = "application/json", produces = "application/json")
	public Compte saveCompteEpargne(@RequestBody CompteEpargne c){
		c.setEpargne(true);
		return compteRepository.save(c);
		
		
	}
	

}

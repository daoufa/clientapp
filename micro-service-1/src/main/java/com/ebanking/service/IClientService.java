package com.ebanking.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Compte;
import com.ebanking.model.Operation;
@RestController
public interface IClientService {
	@GetMapping(value = "/compteConsulte/{id}")
public Compte consulterCompte(@PathVariable(name="id") Long numCpte);
	
	public void virement(Long numCpte1,Long numCpte2,double montant);
	public void rechargeTelephone(Long numCpte,String numTel,double montant);
	
	public Page<Operation> listOperation(Long numCpte,int page,int size);

}
package com.ebanking.service;

import org.springframework.data.domain.Page;

import com.ebanking.model.Compte;
import com.ebanking.model.Operation;
import com.ebanking.model.Virement;

public interface IBanqueService {
	public Compte consulterCompte(Long numCpte);
	public void verser(Long numCpt,double montant);
	public void retirer(Long numCpt,double montant);
	public void virement(Long numCpte1,Long numCpte2,double montant);
	public void rechargeTelephone(Long numCpte,String numTel,double montant);
	
	public Page<Operation> listOperation(Long numCpte,int page,int size);

}

package com.ebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebanking.model.Compte;
import com.ebanking.model.CompteCourant;
import com.ebanking.model.Operation;
import com.ebanking.model.RechargeTelephone;
import com.ebanking.model.Virement;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.OperationRepository;
@Service
@Transactional
public class ClientServiceImpl implements IClientService {


	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository OperationRepository;
	
	@Override
	public Compte consulterCompte(Long numCpte) {
		Compte cpt=compteRepository.findById(numCpte).orElse(null);
		if(cpt==null) throw new RuntimeException("Compte introuvable");
		return cpt;
	}

	@Override
	public void virement(Long numCpte1, Long numCpte2, double montant) {
		if(numCpte1==numCpte2) 
			throw new RuntimeException("le virement est vers votre compte!");
		retirer(numCpte1, montant);
		verser(numCpte2, montant);
		Compte compte1=consulterCompte(numCpte1);
		Compte compte2=consulterCompte(numCpte2);
		Operation operation=new Virement(compte1,compte2,montant) ;
		OperationRepository.save(operation);

	}

	
	
	@Override
	public Page<Operation> listOperation(Long numCpte, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	public void verser(Long numCpt, double montant) {
		Compte cpt=consulterCompte(numCpt);
		cpt.setSolde(cpt.getSolde()+montant);
		compteRepository.save(cpt);
		
		
	}

	
	public void retirer(Long numCpt, double montant) {
		Compte cpt=consulterCompte(numCpt);
		double facilitesCaisse=0;
		if(cpt instanceof CompteCourant)
			facilitesCaisse=((CompteCourant)cpt).getDecouvert();
		if(cpt.getSolde()+facilitesCaisse<montant)
			throw new RuntimeException("Solde insuffisanr");
		cpt.setSolde(cpt.getSolde()-montant);
		compteRepository.save(cpt);
		
	}

	@Override
	public void rechargeTelephone(Long numCpte, String numTel,double montant) {
		retirer(numCpte, montant);
		Compte compte=consulterCompte(numCpte);
		OperationRepository.save(new RechargeTelephone(montant, compte, numTel));
		//TODO:comment envoyer une recharge?
	}

}

package com.ebanking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebanking.model.Client;
import com.ebanking.model.Compte;
import com.ebanking.model.CompteCourant;
import com.ebanking.model.CompteEpargne;
import com.ebanking.model.RechargeTelephone;
import com.ebanking.model.Virement;
import com.ebanking.repository.ClientRepository;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.RechargeTelephoneRepository;
import com.ebanking.repository.VirementRepository;
@Service
@Transactional
public class ClientServiceImpl implements IClientService {


	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private VirementRepository virementRepository;
	@Autowired
	private RechargeTelephoneRepository rechargeTelephoneRepository;
	
	@Override
	public Compte consulterCompte(Long numCpte) {
		Compte cpt=compteRepository.findById(numCpte).orElse(null);
		if(cpt==null) throw new RuntimeException("Compte introuvable");
		cpt.getClient().setComptes(null);;
		return cpt;
	}
	

	

	/*@Override
	public List<Compte> getCompteEpargnes(Long cltid) {
		Client client=clientRepository.findById(cltid).orElse(null);
		List<Compte> cpt=compteRepository.findByClient(client);
		List<Compte> cEpargne=new ArrayList<Compte>();
		for (Compte compte : cpt) {
			if (compte instanceof CompteEpargne) {
				
				cEpargne.add((CompteEpargne)compte);
				
			}
			
		}
		return cEpargne;
	}*/
	
	

	@Override
	public void virement(Long numCpte1, Long numCpte2, double montant) {
		if(numCpte1==numCpte2) 
			throw new RuntimeException("le virement est vers votre compte!");
		retirer(numCpte1, montant);
		verser(numCpte2, montant); 
		

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
			throw new RuntimeException("Solde insuffisant");
		cpt.setSolde(cpt.getSolde()-montant);
		compteRepository.save(cpt);
		
	}

	@Override
	public void rechargeTelephone(Long numCpte, String numTel,double montant,Date date) {
		retirer(numCpte, montant);
		
		//TODO:comment envoyer une recharge?
	}










}

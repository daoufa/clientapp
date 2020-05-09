package com.ebanking.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebanking.model.Client;
import com.ebanking.model.Compte;
import com.ebanking.model.CompteCourant;
import com.ebanking.model.Operation;
import com.ebanking.model.RechargeTelephone;
import com.ebanking.model.Virement;
import com.ebanking.repository.ClientRepository;
import com.ebanking.repository.CompteRepository;
import com.ebanking.repository.OperationRepository;


@Service
@Transactional
public class BanqueServiceImpl implements IBanqueService {
	
	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	
	
	@Override
	public void EnrolerClient(Client client) {
		if(clientRepository.existsById(client.getCode()))
		clientRepository.save(client);
		
	}

	@Override
	public void ResilierClient(Client client) {
		// TODO Auto-generated method stub
		clientRepository.delete(client);
	}

	@Override
	public void SuspendreClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EnleverSuspenduClient(Client client) {
		// TODO Auto-generated method stub
		
	}

}

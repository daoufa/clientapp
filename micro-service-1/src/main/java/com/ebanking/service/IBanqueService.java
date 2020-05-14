package com.ebanking.service;

import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Client;
import com.ebanking.model.Compte;
import com.ebanking.model.Virement;


public interface IBanqueService {
	
	public void EnrolerClient(Client client);
	public void ResilierClient(Client client);
	public void SuspendreClient(Client client);
	public void EnleverSuspenduClient(Client client);
}

package com.ebanking.service;

import com.ebanking.model.Agence;
import com.ebanking.model.Agent;

public interface IAdminService {
	
	public Agence createAgence(Agence agence);
	public Agent ajouterAgent(Agent agent);
	public void supprimerAgent(Agent agent);
	public Agent changeAgence(Agence agence,Agent agent);
	
	

}

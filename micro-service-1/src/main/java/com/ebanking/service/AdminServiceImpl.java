package com.ebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebanking.model.Agence;
import com.ebanking.model.Agent;
import com.ebanking.repository.AgenceRepository;
import com.ebanking.repository.AgentRepository;


@Service
@Transactional
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private AgentRepository agentRepository ;
	@Autowired
	private AgenceRepository agenceRepository ;
	

	@Override
	public Agence createAgence(Agence agence) {
		return agenceRepository.save(agence);
	}

	@Override
	public Agent ajouterAgent(Agent agent) {
		return agentRepository.save(agent);
		
	}

	@Override
	public void supprimerAgent(Agent agent) {
		agentRepository.delete(agent);
		
	}

	@Override
	public Agent changeAgence(Agence agence,Agent agent) {
		agent.setAgence(agence);
		return agentRepository.save(agent);
	}

	
}

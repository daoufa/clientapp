package com.ebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.ebanking.model.Agence;
import com.ebanking.model.Agent;
import com.ebanking.repository.AgenceRepository;
import com.ebanking.repository.AgentRepository;

@Controller
public class agentController {
	@Autowired
	private AgenceRepository agenceRepository;

	@Autowired
	private AgentRepository agentRepository;

	@GetMapping("/agent")
	public String agent(Model model, @RequestParam(name = "idagence", defaultValue = "1") Long idAgence,
			@RequestParam(name = "isModifier", defaultValue = "false") boolean isModifier) {

		Agence agence = agenceRepository.findById(idAgence).get();
		model.addAttribute("agence", agence);
		model.addAttribute("nvAgent", new Agent());
		model.addAttribute("isModifier", isModifier);
		return "agent";
	}

	@PostMapping("/creerAgent")
	public RedirectView creerAgent(Model model, @ModelAttribute("nvAgent") Agent ag,
			@RequestParam(name = "idagence", defaultValue = "1") Long idAgence,
			@RequestParam(name = "idagent", defaultValue = "0") Long idAgent) {
		Agence agence = agenceRepository.findById(idAgence).get();
		if (idAgent != null && idAgent != 0) {
			Agent agent = agentRepository.findById(idAgent).get();
			agent.setCode(idAgent);
			agent.setNom(ag.getNom());
			agent.setPrenom(ag.getPrenom());
			agent.setEmail(ag.getEmail());
			agent.setCin(ag.getCin());
			agent.setTelephone(ag.getTelephone());
			agent.setAgence(agence);
			agent.setVille(ag.getVille());

			agenceRepository.save(agence);
		} else {
			ag.setAgence(agence);
			agentRepository.save(ag);
		}
		RedirectView redirect = new RedirectView("agent");
		redirect.addStaticAttribute("idagence", idAgence);
		return redirect;
	}

	@GetMapping("/deletAgent")
	public RedirectView deletAgent(Model model, @RequestParam(name = "idagent") Long idAgent) {

		Agent agent = agentRepository.findById(idAgent).get();
		agentRepository.delete(agent);

		RedirectView redirect = new RedirectView("agent");
		redirect.addStaticAttribute("idagence", agent.getAgence().getId());
		redirect.addStaticAttribute("isModifier", true);
		return redirect;
	}

	@GetMapping("/signalerAgent")
	public RedirectView signalerAgent(Model model, @RequestParam(name = "idagent") Long idAgent) {

		Agent agent = agentRepository.findById(idAgent).get();

		/* add idAgence to agence already has a flag */
		RedirectView redirect = new RedirectView("agent");
		redirect.addStaticAttribute("idagence", agent.getAgence().getId());
		redirect.addStaticAttribute("isModifier", true);
		return redirect;
	}

//	@GetMapping("/editAgent")
//	public String editAgent(Model model, @RequestParam(name = "idagence") Long idAgence) {
//
//		Agence agence = agenceRepository.findById(idAgence).get();
//
//		model.addAttribute("editAgence", agence);
//
//		return "agence";
//	}

//	@GetMapping("/saveAgent")
//	public RedirectView saveAgent(Model model, @RequestParam(name = "editAgence") Agence editAgence) {
//
//		Agence agence = agenceRepository.findById(editAgence.getId()).get();
//
//		model.addAttribute("editAgence", agence);
//
//		return new RedirectView("index");
//	}

}

package com.ebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.ebanking.model.Agence;
import com.ebanking.repository.AgenceRepository;


@Controller
public class AdminController {
	@Autowired
	private AgenceRepository agenceRepository;
//	@GetMapping(value="/login")
//	public String homePage(Model model) {
// 		return "login";
// 	}
//	
//	
//	@GetMapping("/logout")
//	public String logout(Model model) {
//		return "logout";
//	}
	
	
	@GetMapping("/")
	public RedirectView redirectIndex() {
		return new RedirectView("/index");
	}
	
	
	@GetMapping("/index")
	public String index(Model model) {
		
		List<Agence> agences = agenceRepository.findAll();
		for(Agence a : agences) {
//			a.getAgents().size()
		}
		model.addAttribute("agences", agences);
		return "index";
	}
	
	@GetMapping("/agence")
	public String agence(Model model) {
		
		List<Agence> agences = agenceRepository.findAll();
		for(Agence a : agences) {
//			a.getAgents().size()
		}
		model.addAttribute("agences", agences);
		return "index";
	}
	
}


























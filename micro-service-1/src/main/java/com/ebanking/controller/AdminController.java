package com.ebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


import com.ebanking.model.Agence;
import com.ebanking.model.Agent;
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
	public String index(Model model,
			@RequestParam(name="isModifier" , defaultValue="false") boolean isModifier) {
		
		List<Agence> agences = agenceRepository.findAll();
		model.addAttribute("agences", agences);
		model.addAttribute("isModifier", isModifier);
		model.addAttribute("nvAgence", new Agence());
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		
		return "profile";
	}
	
}


























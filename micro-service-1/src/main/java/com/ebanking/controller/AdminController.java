package com.ebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.ebanking.config.GlobalParam;
import com.ebanking.model.Agence;
import com.ebanking.repository.AgenceRepository;
import com.ebanking.repository.UserRepository;

@Controller
public class AdminController {
	@Autowired
	private AgenceRepository agenceRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GlobalParam globalParam;
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
	public String index(Model model, @RequestParam(name = "isModifier", defaultValue = "false") boolean isModifier) {
		System.out.println("decouvert" + new GlobalParam().getDecouvert());
		List<Agence> agences = agenceRepository.findAll();
		model.addAttribute("agences", agences);
		model.addAttribute("isModifier", isModifier);
		model.addAttribute("nvAgence", new Agence());
		return "index";
	}

	@GetMapping("/globalParam")
	public String globalParam(Model model) {

		model.addAttribute("tauxInterets", globalParam.getTauxInterets());
		model.addAttribute("decouvert", globalParam.getDecouvert());
//		model.addAttribute("globalParam", globalParam);
		return "globalParam";
	}

	@PostMapping("/setGlobalParam")
	public RedirectView setGlobalParam(Model model,
//			@ModelAttribute("globalParam") GlobalParam g
			@RequestParam(name = "decouvert") double decouvert,
			@RequestParam(name = "tauxInterets") double tauxInterets) {

		globalParam.setDecouvert(decouvert);
		globalParam.setTauxInterets(tauxInterets);
		return new RedirectView("index");
	}

	@GetMapping("/profile")
	public String profile(Model model) {
//		User user = userRepository.findByUsername(HttpServletRequest.getRemoteUser());
		return "profile";
	}

}

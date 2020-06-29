package com.ebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.ebanking.config.Authentication;
import com.ebanking.config.GlobalParam;
import com.ebanking.model.Admin;
import com.ebanking.model.Agence;
import com.ebanking.model.User;
import com.ebanking.repository.AdminRepository;
import com.ebanking.repository.AgenceRepository;
import com.ebanking.repository.UserRepository;

@Controller

public class AdminController {
//
////	@Value("${admin.username}")
//	private String username = "admin";
////	@Value("${admin.password}")
//	private String password = "123456";

	private boolean isAuthenticated;
	@Autowired
	private Authentication authenticated;
	@Autowired
	private AgenceRepository agenceRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GlobalParam globalParam;

	@GetMapping(value = "/login")
	public String login(Model model, @RequestParam(name = "error", defaultValue = "false") boolean error) {
		model.addAttribute("error", error);
		return "login";
	}

	@GetMapping(value = "/signout")
	public String signout() {
		authenticated.setAuthenticated(false);
		return "login";
	}

	@PostMapping("/authenticate")
	public RedirectView authenticate(Model model, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		if (username.equals("admin") && password.equals("123456")) {
//			isAuthenticated = true;
			authenticated.setAuthenticated(true);
			RedirectView redirect = new RedirectView("/");
			return redirect;
		} else {
//			isAuthenticated = false;
			authenticated.setAuthenticated(false);
			RedirectView redirect = new RedirectView("/login");
			redirect.addStaticAttribute("error", true);
			return redirect;
		}
	}

	@GetMapping("/")
	public RedirectView redirectIndex() {
		return new RedirectView("/index");
	}

	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "isModifier", defaultValue = "false") boolean isModifier) {
		if (authenticated.isAuthenticated() == true) {
			List<Agence> agences = agenceRepository.findAll();
			System.out.println(isAuthenticated);
			model.addAttribute("agences", agences);
			model.addAttribute("isModifier", isModifier);
			model.addAttribute("nvAgence", new Agence());
			return "index";
		} else {
			return "login";
		}
	}

	@GetMapping("/globalParam")
	public String globalParam(Model model) {
		if (authenticated.isAuthenticated() == true) {
			model.addAttribute("tauxInterets", globalParam.getTauxInterets());
			model.addAttribute("decouvert", globalParam.getDecouvert());
//			model.addAttribute("globalParam", globalParam);
			return "globalParam";
		} else {
			return "login";
		}

	}

	@PostMapping("/setGlobalParam")
	public RedirectView setGlobalParam(Model model,
//			@ModelAttribute("globalParam") GlobalParam g
			@RequestParam(name = "decouvert") double decouvert,
			@RequestParam(name = "tauxInterets") double tauxInterets) {

		if (authenticated.isAuthenticated() == true) {
			globalParam.setDecouvert(decouvert);
			globalParam.setTauxInterets(tauxInterets);
			return new RedirectView("index");
		} else {
			return new RedirectView("login");
		}

	}

	@GetMapping("/profile")
	public String profile(Model model) {

		if (authenticated.isAuthenticated() == true) {
			User user = userRepository.findByUsername("admin");
			Admin a = adminRepository.findById(user.getAdminId()).get();
			model.addAttribute("admin", a);
			return "profile";
		} else {
			return "login";
		}

	}

}

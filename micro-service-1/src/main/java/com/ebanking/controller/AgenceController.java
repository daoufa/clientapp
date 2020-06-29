package com.ebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.ebanking.config.Authentication;
import com.ebanking.model.Agence;
import com.ebanking.repository.AgenceRepository;

@Controller
public class AgenceController {
	@Autowired
	private AgenceRepository agenceRepository;

	@Autowired
	private Authentication authenticated;

	@GetMapping("/agence")
	public String agence(Model model) {
		if (authenticated.isAuthenticated() == true) {
			List<Agence> agences = agenceRepository.findAll();
			model.addAttribute("agences", agences);
			model.addAttribute("nvAgence", new Agence());
			return "agence";
		} else {
			return "login";
		}
	}

	@PostMapping("/creerAgence")
	public RedirectView creerAgence(Model model, @ModelAttribute("nvAgence") Agence ag,
			@RequestParam(name = "idagence", defaultValue = "0") Long idAgence) {
		if (authenticated.isAuthenticated() == true) {
			if (idAgence != null && idAgence != 0) {
				Agence agence = agenceRepository.findById(idAgence).get();
				agence.setId(idAgence);
				agence.setVille(ag.getVille());
				agence.setAdresse(ag.getAdresse());
				agence.setNom(ag.getNom());
				agenceRepository.save(agence);
			} else {
				agenceRepository.save(ag);
			}
			return new RedirectView("/index");
		} else {
			return new RedirectView("login");
		}

	}

	@GetMapping("/deletAgence")
	public RedirectView deletAgence(Model model, @RequestParam(name = "idagence") Long idAgence) {
		if (authenticated.isAuthenticated() == true) {
			Agence agence = agenceRepository.findById(idAgence).get();
			agenceRepository.delete(agence);

			RedirectView redirect = new RedirectView("index");
			redirect.addStaticAttribute("isModifier", true);
			return redirect;
		} else {
			return new RedirectView("login");
		}

	}

	@GetMapping("/signalerAgence")
	public RedirectView signalerAgence(Model model, @RequestParam(name = "idagence") Long idAgence) {
		Agence agence = agenceRepository.findById(idAgence).get();

		/* add idAgence to agence already has a flag */
		RedirectView redirect = new RedirectView("index");
		redirect.addStaticAttribute("isModifier", true);
		return redirect;

	}

	@GetMapping("/editAgence")
	public String editAgence(Model model, @RequestParam(name = "idagence") Long idAgence) {
		if (authenticated.isAuthenticated()) {
			Agence agence = agenceRepository.findById(idAgence).get();

			model.addAttribute("editAgence", agence);

			return "agence";
		} else {
			return "login";
		}

	}

//	@GetMapping("/saveAgence")
//	public RedirectView saveAgence(Model model, @RequestParam(name = "editAgence") Agence editAgence) {
//
//		Agence agence = agenceRepository.findById(editAgence.getId()).get();
//
//		model.addAttribute("editAgence", agence);
//
//		return new RedirectView("index");
//	}

}

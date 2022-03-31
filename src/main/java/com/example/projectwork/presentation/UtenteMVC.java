package com.example.projectwork.presentation;


import javax.servlet.http.HttpSession;

import com.example.projectwork.model.UtenteEntity;
import com.example.projectwork.service.UtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class UtenteMVC {

	@Autowired
	UtenteService usrv;

	@GetMapping
	public String get(Model model) {

		String titolo = "Inserisci le credenziali";

		model.addAttribute("formUtente", new UtenteEntity());

		model.addAttribute("titolo", titolo);

		return "login";
	}

	@PostMapping("/login-utente")
	public String loginUtente(@ModelAttribute UtenteEntity utenteForm, Model model, HttpSession session) {

		try {

			UtenteEntity utente = usrv.login(utenteForm);
			System.out.println("utente: " + utente);
			session.setAttribute("utente", utente);

			return "redirect:" + session.getAttribute("chiamante");

		} catch (Exception e) {
			model.addAttribute("errore", e.getMessage());
			return get(model);
		}
	}

	@GetMapping("/logout") // N.B: url è "/login/logout"
	public String logout(HttpSession session) {

		session.invalidate(); // resetta la sessione e gli oggetti associati
		return "redirect:/";

	}
}

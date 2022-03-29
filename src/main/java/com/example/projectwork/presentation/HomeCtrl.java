package com.example.projectwork.presentation;

import javax.servlet.http.HttpSession;

import com.example.projectwork.model.UtenteEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("utente")
public class HomeCtrl {

    @GetMapping
    public String homeCliente(@ModelAttribute UtenteEntity utente, HttpSession session) {
        session.setAttribute("chiamante", "/");
        return "homepage";
    }

    @GetMapping("/dispo")
    public String disponibilita(@ModelAttribute UtenteEntity utente) {
        return "disponibilita";
    }

    @GetMapping("/admin")
    public String admin(@ModelAttribute UtenteEntity utente) {
        return "admin";
    }

    @GetMapping("/veicolo")
    public String veicoloK(@ModelAttribute UtenteEntity utente) {
        return "veicoloK";
    }

    @GetMapping("/utente")
    public String utente(@ModelAttribute UtenteEntity utente) {
        return "utente";
    }

    @GetMapping("/pannello")
    public String pannello(@ModelAttribute UtenteEntity utente) {
        return "pannello";
    }

    @GetMapping("/index")
    public String index(@ModelAttribute UtenteEntity utente) {
        return "index";
    }

    /*
    @GetMapping
    public String homeCliente(@ModelAttribute UtenteEntity utente) {
        return "homepage";
    }*/
    
}

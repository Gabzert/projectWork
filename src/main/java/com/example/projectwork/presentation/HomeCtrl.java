package com.example.projectwork.presentation;

import javax.servlet.http.HttpSession;

import com.example.projectwork.model.UtenteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
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

    @GetMapping("/veicolo/{id}")
    public String veicoloK(@ModelAttribute UtenteEntity utente,@PathVariable int id,Model m) {

        m.addAttribute("idl",id);
        m.addAttribute("Veicolo1", "Veicolo");

        return "veicolo";
    }

    @GetMapping("/utente")
    public String utente(@ModelAttribute UtenteEntity utente) {
        return "utente";
    }

    @GetMapping("/pannello")
    public String pannello(@ModelAttribute UtenteEntity utente1,@SessionAttribute UtenteEntity utente) {

        if(utente.getRuolo().equals("amministratore")){
            return "pannello";
        }

        return "redirect:/";
    }
    @GetMapping("/privacy")
    public String privacy(@ModelAttribute UtenteEntity utente) {
        return "privacy";
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

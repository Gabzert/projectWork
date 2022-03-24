package com.example.projectwork.presentation;



import com.example.projectwork.model.UtenteEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@RequestMapping("/prenotazione")
@SessionAttributes("utente")
public class PrenotazioneMVC {

    @GetMapping
    public String loginCheck(@ModelAttribute("utente") UtenteEntity utente){
        if(utente == null ){
            return "redirect:/login";

        }

        return "redirect:/api/prenotazioni";

    }
}

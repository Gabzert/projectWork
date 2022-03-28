package com.example.projectwork.presentation;

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
    public String homeCliente(@ModelAttribute UtenteEntity utente) {
        return "homepage";
    }
    
}

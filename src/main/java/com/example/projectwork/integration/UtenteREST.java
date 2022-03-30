package com.example.projectwork.integration;

import com.example.projectwork.model.UtenteEntity;
import com.example.projectwork.service.UtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@RequestMapping("api/utenti")
public class UtenteREST {
    @Autowired
    UtenteService service;

    @GetMapping("/utente")
    public UtenteEntity prendiUtenteById(@SessionAttribute UtenteEntity utente){
        return service.getUtenteById(utente.getId());
    }
}

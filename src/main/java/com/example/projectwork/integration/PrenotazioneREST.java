package com.example.projectwork.integration;


import com.example.projectwork.service.PrenotazioneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prenotazione")
public class PrenotazioneREST {
    
    @Autowired
    private PrenotazioneService serv;


}

package com.example.projectwork.integration;


import com.example.projectwork.model.UtenteEntity;
import com.example.projectwork.model.VeicoloEntity;
import com.example.projectwork.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin")
@SessionAttributes("utente")
public class AdminREST {
    
    @Autowired
    AdminService service;

    @PostMapping("/addVeicolo")
    public ResponseEntity<VeicoloEntity> addVeicolo(@ModelAttribute VeicoloEntity veicolo, @SessionAttribute UtenteEntity utente,@RequestPart (name="file") MultipartFile file){
        try{
            if (!utente.getRuolo().equals("amministratore")){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            
            return ResponseEntity.ok(service.addVeicolo(veicolo,file));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
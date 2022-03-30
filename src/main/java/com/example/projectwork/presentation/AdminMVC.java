package com.example.projectwork.presentation;

import com.example.projectwork.model.UtenteEntity;
import com.example.projectwork.model.VeicoloEntity;
import com.example.projectwork.service.AdminService;
import com.example.projectwork.service.VeicoloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminMVC {

    @Autowired
    AdminService service;
    
    @PostMapping("/modifyVeicolo")
    public String modifyVeicolo(@ModelAttribute("veicolo") VeicoloEntity veicolo,
            @SessionAttribute UtenteEntity utente, @RequestPart (name = "file", required=false) MultipartFile file1) {
        try {
            if (!utente.getRuolo().equals("amministratore")) {
                return "redirect:/login";
            }
            System.out.println("sono arrivato qui");

            service.updateVeicolo(veicolo, file1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/pannello";
    }
}

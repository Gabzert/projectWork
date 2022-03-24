package com.example.projectwork.integration;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.projectwork.model.PrenotazioneEntity;
import com.example.projectwork.service.PrenotazioneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneREST {
    
    @Autowired
    PrenotazioneService service;


    @GetMapping
    public List<PrenotazioneEntity> getAll(){

      return  service.getall();
    }




    @PostMapping("/addPrenotazione")
    public String addPrenotazione(@RequestBody PrenotazioneEntity prenotazione, HttpSession session){


      try {
        service.addPrenotazione(prenotazione);
        
        session.setAttribute("esito", "Cancellazione avvenuta correttamente.");
        return "Cancellazione avvenuta correttamente.";
      } catch(Exception e) {
        session.setAttribute("esito", "Qualcosa è andato storto: " + e.getMessage() + ".");
        return "Qualcosa è andato storto: " + e.getMessage() + ".";
      }
  
    }




    @PostMapping("/editPrenotazione")
    public void editPrenotazione(@RequestBody PrenotazioneEntity prenotazioneForm ){

      service.editPrenotazione(prenotazioneForm);

    }




    @DeleteMapping("/{id}")
    public void deletePrenotazione(@PathVariable("id") int id) {
      service.deletePrenotazione(id);
      
    }
}

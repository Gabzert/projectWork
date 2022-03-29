package com.example.projectwork.integration;

import java.util.List;



import com.example.projectwork.model.PrenotazioneEntity;
import com.example.projectwork.model.UtenteEntity;
import com.example.projectwork.service.PrenotazioneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@RequestMapping("/api/prenotazioni")
@SessionAttributes("utente")
public class PrenotazioneREST {

  @Autowired
  PrenotazioneService service;

  @GetMapping
  public ResponseEntity<List<PrenotazioneEntity>> getAll(@SessionAttribute UtenteEntity utente) {
  
    try{
      if(utente.getRuolo().equals("")){
          return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
      }
      
      return ResponseEntity.ok(service.getall(utente.getId()));

  }catch(Exception e){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}

  

  @PostMapping("/addPrenotazione")
    public String addPrenotazione(@RequestBody PrenotazioneEntity prenotazione,@SessionAttribute UtenteEntity utente){
      try {
            if(!utente.getRuolo().equals("")){
            service.addPrenotazione(prenotazione);
            return "Prenotazione effettuata";
            }
           
          } catch(Exception e) {
            return e.getMessage();
          }
      return null;
      }

    

  @PostMapping("/editPrenotazione")
  public void editPrenotazione(@RequestBody PrenotazioneEntity prenotazioneForm,@SessionAttribute UtenteEntity utente) {
    if(!utente.getRuolo().equals("")){
    service.editPrenotazione(prenotazioneForm);
    }
  }

  @DeleteMapping("/{id}")
  public void deletePrenotazione(@PathVariable("id") int id, @SessionAttribute UtenteEntity utente) {
    if(!utente.getRuolo().equals("")){ 
    service.deletePrenotazione(id);
    }
  }
}

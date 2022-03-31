package com.example.projectwork.integration;

import java.util.List;

import com.example.projectwork.model.PrenotazioneDTO;
import com.example.projectwork.model.PrenotazioneEntity;
import com.example.projectwork.model.UtenteEntity;
import com.example.projectwork.service.PrenotazioneService;
import com.example.projectwork.service.VeicoloService;

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

  @Autowired
  VeicoloService vService;

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
    public String addPrenotazione(@RequestBody PrenotazioneDTO prenotazione,@SessionAttribute UtenteEntity utente){
      System.out.println(utente);
      System.out.println(prenotazione);
      try {
            if(!utente.getRuolo().equals("")){
            PrenotazioneEntity p = new PrenotazioneEntity();
            p.setData_prenotazione(prenotazione.getData_prenotazione());
            p.setVeicolo(vService.getVeicoloById(prenotazione.getVeicolo_id()));
            p.setUtente(utente);
            p.setStatus(prenotazione.getStatus());
            service.addPrenotazione(p);
            System.out.println(p);
            return "Prenotazione effettuata";
            }
           
          } catch(Exception e) {
            System.out.println(e);
            return e.getMessage();
          }
      return null;
      }

    

  @PostMapping("/editPrenotazione")
  public void editPrenotazione(@RequestBody PrenotazioneDTO prenotazione_editata ,@SessionAttribute UtenteEntity utente) {
    if(!utente.getRuolo().equals("")){
      PrenotazioneEntity p = service.getById(prenotazione_editata.getId());
      p.setData_prenotazione(prenotazione_editata.getData_prenotazione());
      p.setVeicolo(vService.getVeicoloById(prenotazione_editata.getVeicolo_id())); 
      service.editPrenotazione(p);
    }
  }

  @GetMapping("/deletePrenotazione/{id}")
  public void deletePrenotazione(@PathVariable("id") int id,@SessionAttribute UtenteEntity utente) {
    if(!utente.getRuolo().equals("")){ 
    service.deletePrenotazione(id);
    }
  }

  @GetMapping("/terminaPrenotazione/{id}")
  public void terminaPrenotazione(@PathVariable("id") int id,@SessionAttribute UtenteEntity utente) {
    if(!utente.getRuolo().equals("")){ 
    System.out.println("------------entrato nel termina--------------------");
    service.terminaPrenotazione(id);
    }
  }
}

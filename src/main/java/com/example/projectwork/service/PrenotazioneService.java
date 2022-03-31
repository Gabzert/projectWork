package com.example.projectwork.service;

import java.util.List;
import java.util.Optional;

import com.example.projectwork.model.PrenotazioneEntity;
import com.example.projectwork.repository.PrenotazioneDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PrenotazioneService {
    
    @Autowired
    PrenotazioneDB db;

    public List<PrenotazioneEntity> getall(int utente_id){

        return db.findByUtenteId(utente_id);
    }

    public PrenotazioneEntity getById(int id){

        return db.findById(id);
        
    }

    public PrenotazioneEntity addPrenotazione(PrenotazioneEntity prenotazione){

        return db.save(prenotazione);

    }

    public PrenotazioneEntity editPrenotazione(PrenotazioneEntity prenotazione){

        return db.save(prenotazione);
    }

    public void deletePrenotazione(int id ){

        db.deleteById(id);
    }

    public void terminaPrenotazione(int id){
        System.out.println("------------entrato nel service --------------------------");
        PrenotazioneEntity  pren = db.getById(id);
        pren.setStatus("terminata");
        db.save(pren);
    }
}

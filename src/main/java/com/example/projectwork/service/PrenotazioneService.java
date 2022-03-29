package com.example.projectwork.service;

import java.util.List;

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


    public PrenotazioneEntity addPrenotazione(PrenotazioneEntity prenotazione){

        return db.save(prenotazione);

    }

    public PrenotazioneEntity editPrenotazione(PrenotazioneEntity prenotazione){

        return db.save(prenotazione);
    }

    public void deletePrenotazione(int id ){

        db.deleteById(id);
    }

}

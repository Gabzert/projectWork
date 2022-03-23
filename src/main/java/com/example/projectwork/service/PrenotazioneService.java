package com.example.projectwork.service;

import java.util.List;

import com.example.projectwork.model.PrenotazioneEntity;
import com.example.projectwork.repo.PrenotazioneDB;

import org.springframework.stereotype.Service;


@Service
public class PrenotazioneService {
    
    @Autowired
    PrenotazioneDB db;

    public List<PrenotazioneEntity> getall(){

        return db.findAll();
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

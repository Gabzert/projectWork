package com.example.projectwork.service;

import java.util.List;
import java.util.Optional;

import com.example.projectwork.model.VeicoliEntity;
import com.example.projectwork.repository.VeicoliDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeicoloService {

    @Autowired
    VeicoliDB vDB;

    public List<VeicoliEntity> getVeicoli() {
        return vDB.findAll();
    }

    public VeicoliEntity getVeicoloById(int id) {
        return vDB.findVeicoloById(id);
    }


    public List<VeicoliEntity> getVeicoloByCategoria(String categoria) {

        return vDB.findByCategoria(categoria);
    }

    public List<VeicoliEntity> getVeicoloByIndirizzo(String indirizzo) {

        return vDB.findByIndirizzo(indirizzo);
    }

    public List<VeicoliEntity> getVeicolocoloByDescrizione(String descrizione) {

        return vDB.findByDescrizione(descrizione);
    }

    public List<VeicoliEntity> getVeicoloByAlimentazione(String alimentazione) {

        return vDB.findByAlimentazione(alimentazione);
    }

    public List<VeicoliEntity> getRangePrezzo(double min, double max) {

        return vDB.findByPrezzoBetween(min, max);
    }

}

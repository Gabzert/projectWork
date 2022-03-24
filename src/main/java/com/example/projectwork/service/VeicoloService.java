package com.example.projectwork.service;

import java.util.List;

import com.example.projectwork.model.VeicoloEntity;
import com.example.projectwork.repository.VeicoliDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeicoloService {

    @Autowired
    VeicoliDB vDB;

    public List<VeicoloEntity> getVeicoli(){
        return vDB.findAll();
    }
    public List<VeicoloEntity> getVeicoloByCategoria(String categoria){
		
		return vDB.findByCategoria(categoria);
	}

    public List<VeicoloEntity> getVeicolocoloByDescrizione(String descrizione){
		
		return vDB.findByDescrizione(descrizione);
    }
        public List<VeicoloEntity> getVeicoloByIndirizzo(String indirizzo){
		
            return vDB.findByIndirizzo(indirizzo);
        }
        public List<VeicoloEntity> getVeicoloByAlimentazione(String alimentazione){
		
            return vDB.findByAlimentazione(alimentazione);
        }
        public List<VeicoloEntity> getRangePrezzo(double min, double max){
		
            return vDB.findByPrezzoBetween(min, max);
        }
        public VeicoloEntity getVeicolo(int id) {
		
            return vDB.findById(id);
        }
    }


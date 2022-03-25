package com.example.projectwork.repository;

import java.util.List;

import com.example.projectwork.model.VeicoliEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeicoliDB extends JpaRepository<VeicoliEntity,Integer> {

    List<VeicoliEntity> findByCategoria(String categoria); 
    List<VeicoliEntity> findByDescrizione(String descrizione);
    List<VeicoliEntity> findByIndirizzo(String indirizzo);
    List<VeicoliEntity> findByAlimentazione(String alimentazione);
    List<VeicoliEntity> findByPrezzoBetween(double min, double max); 
    
    public VeicoliEntity findVeicoloById(int id);
}

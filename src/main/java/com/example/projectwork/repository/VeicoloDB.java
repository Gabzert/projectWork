package com.example.projectwork.repository;

import java.util.List;

import com.example.projectwork.model.VeicoloEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeicoloDB extends JpaRepository<VeicoloEntity,Integer> {

    List<VeicoloEntity> findByCategoria(String categoria); 
    List<VeicoloEntity> findByIndirizzo(String indirizzo);
    List<VeicoloEntity> findByAlimentazione(String alimentazione);
    List<VeicoloEntity> findByPrezzoBetween(double min, double max);
    
     List<VeicoloEntity> findAll();
    
    public VeicoloEntity findVeicoloById(int id);
}

package com.example.projectwork.repository;

import java.util.List;

import com.example.projectwork.model.VeicoloEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeicoliDB extends JpaRepository<VeicoloEntity,Integer> {
    
    public VeicoloEntity findVeicoloById(int id);
}

package com.example.projectwork.repository;

import java.util.List;

import com.example.projectwork.model.PrenotazioneEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneDB extends JpaRepository<PrenotazioneEntity, Integer>{
    List<PrenotazioneEntity> findByUtenteID (int utente_id);
}

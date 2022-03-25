package com.example.projectwork.repository;

import com.example.projectwork.model.DescrizioneEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DescrizioneDB extends JpaRepository<DescrizioneEntity, Integer> {
    
}

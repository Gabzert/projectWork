package com.example.projectwork.repository;

import com.example.projectwork.model.UtenteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UtenteDB extends JpaRepository<UtenteEntity, Integer>{

}

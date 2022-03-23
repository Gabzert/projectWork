package com.example.projectwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.projectWork.model.UtenteEntity;


@Repository
public interface UtenteDB extends JpaRepository<UtenteEntity, Integer>{

}

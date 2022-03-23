package com.example.projectwork.service;
import java.util.List;

import com.example.projectwork.model.UtenteEntity;
import com.example.projectwork.repository.UtenteDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtenteService {
	
	@Autowired
	UtenteDB uDB;
	
	public List<UtenteEntity> getUtenti(){
		return uDB.findAll();
	}
}

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

	public UtenteEntity getUtenteById(int id){
		return uDB.findUtenteById(id);
	}

	public UtenteEntity login(UtenteEntity ut) throws Exception {
		
		List<UtenteEntity> lista = uDB.findAll(); 
		
		for (UtenteEntity utente : lista) {
		
			if(utente.getEmail().equals(ut.getEmail())) { 
				
				if(utente.getPassword().equals(ut.getPassword())) { 
					
					return utente;
					
				}
			}
			
		}
		
		throw new Exception("Credenziali errate.");
	}
	

}



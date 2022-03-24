package com.example.projectwork.integration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.projectwork.model.VeicoloEntity;
import com.example.projectwork.service.VeicoloService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/veicoli")
public class VeicoliREST {

    @Autowired
    VeicoloService service;

    @GetMapping
    public List<VeicoloEntity> getVeicoli(){
        return service.getVeicoli();
    }
/*
	@PostMapping("/desc/{modello}")
	public List<VeicoloEntity> getByDesc(@PathVariable String modello){

		ObjectMapper mapper = service.getVeicoli();
		

		List<VeicoloEntity> veicoli = (List<VeicoloEntity>) obj.get("Students");
		Object[] rentVeic = veicoli
    	.stream()
    	.filter(veicolo -> ((Map)veicolo).get("modello").equals(modello))
    	.toArray();

	}
	*/
    
}

package com.example.projectwork.integration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.projectwork.model.VeicoliEntity;
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

	@GetMapping("categoria/{categoria}")
	public List<VeicoliEntity> getByCategoria(@PathVariable String categoria) {

		return service.getVeicoloByCategoria(categoria);
	}

	@GetMapping("descrizione/{descrizione}")
	public List<VeicoliEntity> getByDescrizione(@PathVariable String descrizione) {

		return service.getVeicolocoloByDescrizione(descrizione);

	}

	@GetMapping("indirizzo/{indirizzo}")
	public List<VeicoliEntity> getByIndirizzo(@PathVariable String indirizzo) {

		return service.getVeicoloByIndirizzo(indirizzo);

	}

	@GetMapping("alimentazione/{alimentazione}")
	public List<VeicoliEntity> getByAlimentazione(@PathVariable String alimentazione) {

		return service.getVeicoloByAlimentazione(alimentazione);

	}

	@GetMapping("/{min}/{max}")
	public List<VeicoliEntity> getPrezzoRange(@PathVariable double min, @PathVariable double max) {
		return service.getRangePrezzo(min, max);
	}

    @GetMapping
    public List<VeicoliEntity> getVeicoli(){
        return service.getVeicoli();
    }

	@GetMapping("/location/{id}")
	public VeicoliEntity getPositon(@PathVariable int id){
		return service.getVeicoloById(id);
	}
/*
	@PostMapping("/desc/{modello}")
	public List<VeicoliEntity> getByDesc(@PathVariable String modello){

		ObjectMapper mapper = service.getVeicoli();
		

		List<VeicoliEntity> veicoli = (List<VeicoliEntity>) obj.get("Students");
		Object[] rentVeic = veicoli
    	.stream()
    	.filter(veicolo -> ((Map)veicolo).get("modello").equals(modello))
    	.toArray();

	}
	*/
    
}

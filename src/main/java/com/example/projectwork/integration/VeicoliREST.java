package com.example.projectwork.integration;

import java.util.List;

import com.example.projectwork.model.VeicoloEntity;

import com.example.projectwork.service.VeicoloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/veicoli")
public class VeicoliREST {

	@Autowired
	VeicoloService service;

	@GetMapping("categoria/{categoria}")
	public List<VeicoloEntity> getByCategoria(@PathVariable String categoria) {

		return service.getVeicoloByCategoria(categoria);
	}

	@GetMapping("descrizione/{descrizione}")
	public List<VeicoloEntity> getByDescrizione(@PathVariable String descrizione) {

		return service.getVeicolocoloByDescrizione(descrizione);

	}

	@GetMapping("indirizzo/{indirizzo}")
	public List<VeicoloEntity> getByIndirizzo(@PathVariable String indirizzo) {

		return service.getVeicoloByIndirizzo(indirizzo);

	}

	@GetMapping("alimentazione/{alimentazione}")
	public List<VeicoloEntity> getByAlimentazione(@PathVariable String alimentazione) {

		return service.getVeicoloByAlimentazione(alimentazione);

	}

	@GetMapping("/{min}/{max}")
	public List<VeicoloEntity> getPrezzoRange(@PathVariable double min, @PathVariable double max) {
		return service.getRangePrezzo(min, max);
	}

	@GetMapping("/{id}")
	public VeicoloEntity getVeicolo(@PathVariable("id") int id) {

		return service.getVeicolo(id);
	}

}

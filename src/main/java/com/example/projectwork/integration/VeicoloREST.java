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
public class VeicoloREST {

	@Autowired
	VeicoloService service;

	@GetMapping("categoria/{categoria}")
	public List<VeicoloEntity> getByCategoria(@PathVariable String categoria) {

		return service.getVeicoloByCategoria(categoria);
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

    @GetMapping
    public List<VeicoloEntity> getVeicoli(){
        return service.getVeicoli();
    }

	@GetMapping("/location/{id}")
	public VeicoloEntity getPositon(@PathVariable int id){
		return service.getVeicoloById(id);
	}


	@GetMapping("/veicolo/{id}")
	public VeicoloEntity getVeicoloById(@PathVariable int id){
		return service.getVeicoloById(id);
	}


	@GetMapping("/veicolo/categoria/{categoria}/citta/{citta}")
	public List<VeicoloEntity> getVeicoloById(@PathVariable String categoria,@PathVariable String citta ){
		return service.getVeicoliByCategoriaECitta(categoria,citta);
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

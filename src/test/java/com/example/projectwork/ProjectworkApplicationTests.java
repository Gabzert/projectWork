package com.example.projectwork;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;
import javax.transaction.Transactional;

=======
import java.util.List;

>>>>>>> main
import com.example.projectwork.model.VeicoloEntity;
import com.example.projectwork.repository.VeicoliDB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ProjectworkApplicationTests {

	@Autowired
	VeicoliDB vecDB;

	@Test
	@Transactional
	void contextLoads() {
		/*ArrayList<Tuple> veicolo = vecDB.getModello();
		for(Tuple v : veicolo ){
		System.out.println("--------------");
		System.out.println(v.get("modello"));
		System.out.println("--------------");
		}*/
	void findCar() {

		List<VeicoloEntity> veicoli = vecDB.findByDescrizione("modello");

		for(VeicoloEntity v : veicoli){
			System.out.println("--------------");
			System.out.println(v);
			System.out.println("--------------");
		}
	}



<<<<<<< HEAD



=======
>>>>>>> main
}

package com.example.projectwork;

import java.util.List;

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
	void findCar() {

		List<VeicoloEntity> veicoli = vecDB.findByDescrizione("modello");

		for(VeicoloEntity v : veicoli){
			System.out.println("--------------");
			System.out.println(v);
			System.out.println("--------------");
		}
	}



}

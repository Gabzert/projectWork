package com.example.projectwork.integration;

import java.util.List;

import com.example.projectwork.model.VeicoloEntity;
import com.example.projectwork.service.VeicoloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}

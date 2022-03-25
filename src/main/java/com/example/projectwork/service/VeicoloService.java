package com.example.projectwork.service;

import java.util.List;
import java.util.Optional;

import com.example.projectwork.model.VeicoloEntity;
import com.example.projectwork.repository.VeicoliDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeicoloService {

    @Autowired
    VeicoliDB vDB;

    public List<VeicoloEntity> getVeicoli(){
        return vDB.findAll();
    }

    public VeicoloEntity getVeicoloById(int id){
        return vDB.findVeicoloById(id);
    }
}

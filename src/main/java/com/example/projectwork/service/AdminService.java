package com.example.projectwork.service;

import java.io.IOException;

import com.example.projectwork.model.VeicoliEntity;
import com.example.projectwork.repository.VeicoliDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AdminService {
    
    @Autowired
    VeicoliDB veicoloDB;

    @Autowired
	FileService fs;

    public VeicoliEntity addVeicolo(VeicoliEntity veicolo, MultipartFile img) throws IOException,Exception{
        
        if(veicolo.getCategoria()  == null || veicolo.getAlimentazione() == null){
            throw new Exception("Errore inserimento dati");
        }

        if(img != null ){
			try{
				String percorso = fs.saveFile("img/veicoli", veicolo.getCategoria()+img.getName(), img);
				veicolo.setImmagine(percorso);
			}catch(IOException e){
				e.printStackTrace();
			}
		}

        return veicoloDB.save(veicolo);
    }
}

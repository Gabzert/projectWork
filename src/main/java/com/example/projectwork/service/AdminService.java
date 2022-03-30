package com.example.projectwork.service;

import java.io.IOException;
import java.util.List;

import com.example.projectwork.model.VeicoloEntity;
import com.example.projectwork.repository.VeicoloDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AdminService {
    
    @Autowired
    VeicoloDB veicoloDB;

    @Autowired
	FileService fs;

    public VeicoloEntity addVeicolo(VeicoloEntity veicolo, MultipartFile img) throws IOException,Exception{
        
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

    public VeicoloEntity updateVeicolo(VeicoloEntity veicolo, MultipartFile img) throws IOException{

        if(img != null && !img.isEmpty()){
            String percorso = fs.saveFile("img/veicoli", veicolo.getCategoria()+img.getName(), img);
            veicolo.setImmagine(percorso);
        }

        return veicoloDB.save(veicolo);
    }


    public Integer deleteVeicolo(int id) throws IOException{
        return veicoloDB.deleteVeicoloById(id);
    }

    public List<VeicoloEntity> getAllVeicoli(){
        return veicoloDB.findAll();
    }
}

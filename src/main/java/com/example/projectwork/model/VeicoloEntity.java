package com.example.projectwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="veicoli")
public class VeicoloEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoria;
    private String immagine;
    private String modello;
    private String marca;
    private String alimentazione;
    private String trazione;
    private double prezzo;
    private String indirizzo;
    private String gps;
    private String status;
    private String cambio;
    private String descrizione;
    private String citta;

    
    
    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getDescrizione() {
        return descrizione;
    }
    
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getCambio() {
        return cambio;
    }
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getImmagine() {
        return immagine;
    }
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getAlimentazione() {
        return alimentazione;
    }
    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }
    public String getTrazione() {
        return trazione;
    }
    public void setTrazione(String trazione) {
        this.trazione = trazione;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public String getGps() {
        return gps;
    }
    public void setGps(String gps) {
        this.gps = gps;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    


    
   
}

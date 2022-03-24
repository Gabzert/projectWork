package com.example.projectwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veicoli")
public class VeicoloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoria;
    private String descrizione;
    private String alimentazione;
    private String indirizzo;
    private String gps;
    private boolean disponibilita;
    private String immagine;
    private String status;
    private double prezzo;
    

    public int getId() {
        return id;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
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

    public boolean getDisponibilita() {
        return disponibilita;
    }

<<<<<<< HEAD
    public void setDisponibilita(Boolean disponibilita) {
=======
    public void setDisponibilita(boolean disponibilita) {
>>>>>>> b1e4a60ae11466ffe813e30af63c530512ed5635
        this.disponibilita = disponibilita;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VeicoloEntity [alimentazione=" + alimentazione + ", categoria=" + categoria + ", descrizione="
                + descrizione + ", disponibilita=" + disponibilita + ", gps=" + gps + ", id=" + id + ", immagine="
                + immagine + ", indirizzo=" + indirizzo + ", prezzo=" + prezzo + ", status=" + status + "]";
    }

  

    

}

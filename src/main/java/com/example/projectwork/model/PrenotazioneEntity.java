package com.example.projectwork.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="prenotazioni")
public class PrenotazioneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data_prenotazione;
    private String status;

    @ManyToOne
    @JoinColumn(name="utente_id")
    private UtenteEntity utente;
    
    @ManyToOne
    @JoinColumn(name="veicolo_id")
    private VeicoliEntity veicolo;


    public PrenotazioneEntity(){

    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_prenotazione() {
        return data_prenotazione;
    }

    public void setData_prenotazione(Date data_prenotazione) {
        this.data_prenotazione = data_prenotazione;
    }

    public UtenteEntity getUtente() {
        return utente;
    }

    public void setUtente(UtenteEntity utente) {
        this.utente = utente;
    }


    public VeicoliEntity getVeicolo() {
        return veicolo;
    }


    public void setVeicolo(VeicoliEntity veicolo) {
        this.veicolo = veicolo;
    }

    


    
}

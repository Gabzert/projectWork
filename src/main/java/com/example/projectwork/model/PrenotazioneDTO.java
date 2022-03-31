package com.example.projectwork.model;

import java.util.Date;

public class PrenotazioneDTO {
    private int id;
    private Date data_prenotazione;
    private String status;
    private int utente_id;
    private int veicolo_id;
    
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getUtente_id() {
        return utente_id;
    }
    public void setUtente_id(int utente_id) {
        this.utente_id = utente_id;
    }
    public int getVeicolo_id() {
        return veicolo_id;
    }
    public void setVeicolo_id(int veicolo_id) {
        this.veicolo_id = veicolo_id;
    }
    @Override
    public String toString() {
        return "PrenotazioneDTO [data_prenotazione=" + data_prenotazione + ", id=" + id + ", status=" + status
                + ", utente_id=" + utente_id + ", veicolo_id=" + veicolo_id + "]";
    }
}

package com.example.projectwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="descrizioni")
public class DescrizioneEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String modello;
    private String marca;
    private int kw;
    private int peso;
    private int cavalli;
    private String trazione;
    private int cilindrata;

    @OneToOne(mappedBy = "descrizione")
    private VeicoloEntity veicolo;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getKw() {
        return kw;
    }
    public void setKw(int kw) {
        this.kw = kw;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public int getCavalli() {
        return cavalli;
    }
    public void setCavalli(int cavalli) {
        this.cavalli = cavalli;
    }
    public String getTrazione() {
        return trazione;
    }
    public void setTrazione(String trazione) {
        this.trazione = trazione;
    }
    public int getCilindrata() {
        return cilindrata;
    }
    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }
}

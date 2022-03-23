package com.example.projectwork.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="utente")
@Scope("Session")
public class UtenteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cognome;
    private Date data_nascita;
    private String email;
    private String password;
    private Enum ruolo;

 
    @OneToMany(mappedBy = "utente")
    private List<PrenotazioneEntity> prenotazioni;
    public List<PrenotazioneEntity> getPrenotazioni(){
		return prenotazioni;
    }
    @JsonIgnore
    

    public UtenteEntity(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum getRuolo() {
        return ruolo;
    }

    public void setRuolo(Enum ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "UtenteEntity [ cognome=" + cognome + ", data_nascita=" + data_nascita +
                 "email=" + email + ", id=" + id + ", nome=" + nome + ", password= "
                + password + ", ruolo=" + ruolo + "]";
    }
}

   
   

    
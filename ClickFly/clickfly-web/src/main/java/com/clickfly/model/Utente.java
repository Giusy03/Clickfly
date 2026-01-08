package com.clickfly.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Utente {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private LocalDateTime dataRegistrazione;
    private BigDecimal saldo;

    public Utente() {}

    public Utente(int id, String nome, String cognome, String email, String telefono, LocalDateTime dataRegistrazione, BigDecimal saldo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.dataRegistrazione = dataRegistrazione;
        this.saldo = saldo;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public LocalDateTime getDataRegistrazione() { return dataRegistrazione; }
    public BigDecimal getSaldo() { return saldo; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setDataRegistrazione(LocalDateTime dataRegistrazione) { this.dataRegistrazione = dataRegistrazione; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }
}


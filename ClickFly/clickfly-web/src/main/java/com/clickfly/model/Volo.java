package com.clickfly.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Volo {
    private int id;
    private String cittaPartenza;
    private String cittaArrivo;
    private LocalDate data;
    private LocalTime oraPartenza;
    private LocalTime oraArrivo;
    private BigDecimal prezzo;
    private String compagnia;
    private int postiDisponibili;

    public Volo(int id, String cittaPartenza, String cittaArrivo, LocalDate data, LocalTime oraPartenza,
                LocalTime oraArrivo, BigDecimal prezzo, String compagnia, int postiDisponibili) {
        this.id = id;
        this.cittaPartenza = cittaPartenza;
        this.cittaArrivo = cittaArrivo;
        this.data = data;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.prezzo = prezzo;
        this.compagnia = compagnia;
        this.postiDisponibili = postiDisponibili;
    }

    public int getId() { return id; }
    public String getCittaPartenza() { return cittaPartenza; }
    public String getCittaArrivo() { return cittaArrivo; }
    public LocalDate getData() { return data; }
    public LocalTime getOraPartenza() { return oraPartenza; }
    public LocalTime getOraArrivo() { return oraArrivo; }
    public BigDecimal getPrezzo() { return prezzo; }
    public String getCompagnia() { return compagnia; }
    public int getPostiDisponibili() { return postiDisponibili; }

    public void setPostiDisponibili(int postiDisponibili) { this.postiDisponibili = postiDisponibili; }
}


package com.clickfly.model;

import java.math.BigDecimal;

public class CarrelloItem {

    private int voloId;
    private String descrizione;
    private String compagnia;
    private BigDecimal prezzo;
    private int quantita;

    public CarrelloItem(int voloId, String descrizione, String compagnia, BigDecimal prezzo) {
        this.voloId = voloId;
        this.descrizione = descrizione;
        this.compagnia = compagnia;
        this.prezzo = prezzo;
        this.quantita = 1;
    }

    public int getVoloId() {
        return voloId;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getCompagnia() {
        return compagnia;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void incrementaQuantita() {
        this.quantita++;
    }
}

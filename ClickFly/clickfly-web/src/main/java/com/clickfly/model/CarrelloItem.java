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

    public int getVoloId() { return voloId; }
    public void setVoloId(int voloId) { this.voloId = voloId; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public String getCompagnia() { return compagnia; }
    public void setCOmpagnia(String compagnia) { this.compagnia = compagnia; }

    public BigDecimal getPrezzo() { return prezzo; }
    public void setPrezzo(BigDecimal prezzo) { this.prezzo = prezzo; }

    public int getQuantita() { return quantita; }
    public void setQuantita(int quantita) { this.quantita = quantita; }

    public void incrementaQuantita() {
        this.quantita++;
    }
}

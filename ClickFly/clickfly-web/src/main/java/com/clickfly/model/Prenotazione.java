package com.clickfly.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Prenotazione {

    private int id;
    private String cittaPartenza;
    private String cittaArrivo;
    private String compagnia;
    private int numeroPasseggeri;
    private BigDecimal prezzoTotale;
    private LocalDateTime dataPrenotazione;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCittaPartenza() { return cittaPartenza; }
    public void setCittaPartenza(String cittaPartenza) { this.cittaPartenza = cittaPartenza; }

    public String getCittaArrivo() { return cittaArrivo; }
    public void setCittaArrivo(String cittaArrivo) { this.cittaArrivo = cittaArrivo; }

    public String getCompagnia() { return compagnia; }
    public void setCompagnia(String compagnia) { this.compagnia = compagnia; }

    public int getNumeroPasseggeri() { return numeroPasseggeri; }
    public void setNumeroPasseggeri(int numeroPasseggeri) { this.numeroPasseggeri = numeroPasseggeri; }

    public BigDecimal getPrezzoTotale() { return prezzoTotale; }
    public void setPrezzoTotale(BigDecimal prezzoTotale) { this.prezzoTotale = prezzoTotale; }

    public LocalDateTime getDataPrenotazione() { return dataPrenotazione; }
    public void setDataPrenotazione(LocalDateTime dataPrenotazione) { this.dataPrenotazione = dataPrenotazione; }
}


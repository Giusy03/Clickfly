package com.clickfly.dao;

import com.clickfly.model.Prenotazione;
import com.clickfly.util.DBManager;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneDAO {

    public void creaPrenotazione(int idUtente, int idVolo, int quantita, BigDecimal prezzoTotale) throws SQLException {
        String sql = "INSERT INTO prenotazioni (id_utente, id_volo, numero_passeggeri, prezzo_totale) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUtente);
            ps.setInt(2, idVolo);
            ps.setInt(3, quantita);
            ps.setBigDecimal(4, prezzoTotale);
            ps.executeUpdate();
        }
    }

    public List<Prenotazione> getByUtente(int idUtente) throws SQLException {

        List<Prenotazione> lista = new ArrayList<>();

        String sql = """
            SELECT p.*, v.citta_partenza, v.citta_arrivo, v.compagnia
            FROM prenotazioni p
            JOIN voli v ON p.id_volo = v.id
            WHERE p.id_utente = ?
            ORDER BY p.data_prenotazione DESC
        """;

        try (Connection conn = DBManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUtente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prenotazione pr = new Prenotazione();
                pr.setId(rs.getInt("id"));
                pr.setCittaPartenza(rs.getString("citta_partenza"));
                pr.setCittaArrivo(rs.getString("citta_arrivo"));
                pr.setCompagnia(rs.getString("compagnia"));
                pr.setNumeroPasseggeri(rs.getInt("numero_passeggeri"));
                pr.setPrezzoTotale(rs.getBigDecimal("prezzo_totale"));
                pr.setDataPrenotazione(rs.getTimestamp("data_prenotazione").toLocalDateTime());

                lista.add(pr);
            }
        }
        return lista;
    }

}


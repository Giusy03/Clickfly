package com.clickfly.dao;

import com.clickfly.model.Volo;
import com.clickfly.util.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoloDAO {

    public List<Volo> cercaVoli(String cittaPartenza, String cittaArrivo, Date data) throws SQLException {
        List<Volo> voli = new ArrayList<>();
        String sql = "SELECT * FROM voli WHERE citta_partenza=? AND citta_arrivo=? AND data=?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cittaPartenza);
            stmt.setString(2, cittaArrivo);
            stmt.setDate(3, data);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                voli.add(new Volo(
                        rs.getInt("id"),
                        rs.getString("citta_partenza"),
                        rs.getString("citta_arrivo"),
                        rs.getDate("data").toLocalDate(),
                        rs.getTime("ora_partenza").toLocalTime(),
                        rs.getTime("ora_arrivo").toLocalTime(),
                        rs.getBigDecimal("prezzo"),
                        rs.getString("compagnia"),
                        rs.getInt("posti_disponibili")
                ));
            }
        }
        return voli;
    }

    public static Volo getById(int id) {
    String sql = "SELECT * FROM voli WHERE id = ?";
    try (Connection conn = DBManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Volo(
                rs.getInt("id"),
                rs.getString("citta_partenza"),
                rs.getString("citta_arrivo"),
                rs.getDate("data").toLocalDate(),
                rs.getTime("ora_partenza").toLocalTime(),
                rs.getTime("ora_arrivo").toLocalTime(),
                rs.getBigDecimal("prezzo"),
                rs.getString("compagnia"),
                rs.getInt("posti_disponibili")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

}


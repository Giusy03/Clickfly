package com.clickfly.dao;

import com.clickfly.model.Utente;
import com.clickfly.util.DBManager;

import java.math.BigDecimal;
import java.sql.*;

public class UtenteDAO {

    public Utente login(String email, String passwordHash) throws SQLException {

        String sql = "SELECT * FROM utenti WHERE email = ? AND password_hash = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, passwordHash);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                u.setSaldo(rs.getBigDecimal("saldo"));
                return u;
            }
        }
        return null;
    }

    public void aggiornaSaldo(int idUtente, BigDecimal nuovoSaldo) throws SQLException {
        String sql = "UPDATE utenti SET saldo=? WHERE id=?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBigDecimal(1, nuovoSaldo);
            stmt.setInt(2, idUtente);
            stmt.executeUpdate();
        }
    }
}


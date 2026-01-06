package com.clickfly.servlets;

import com.clickfly.model.Utente;
import com.clickfly.util.DBManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordHash = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);

        try (Connection conn = DBManager.getConnection()) {
            String sql = "SELECT * FROM utenti WHERE email=? AND password_hash=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, passwordHash);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente utente = new Utente();
                utente.setId(rs.getInt("id"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setEmail(rs.getString("email"));
                utente.setTelefono(rs.getString("telefono"));

                java.sql.Timestamp ts = rs.getTimestamp("data_registrazione");
                if (ts != null) {
                    utente.setDataRegistrazione(ts.toLocalDateTime());
                }

                HttpSession session = request.getSession();
                session.setAttribute("utente", utente);
                response.sendRedirect("utente.jsp");

            } else {
                response.sendRedirect("login.jsp?error=Email o password non corretti");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=Errore nel login");
        }
    }
}


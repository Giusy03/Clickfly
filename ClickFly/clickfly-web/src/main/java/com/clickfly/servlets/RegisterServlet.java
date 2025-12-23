package com.clickfly.servlets;

import com.clickfly.util.DBManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telefono = request.getParameter("telefono");

        String passwordHash = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);

        try (Connection conn = DBManager.getConnection()) {
            String sql = "INSERT INTO utenti (nome, cognome, email, password_hash, telefono) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, cognome);
            ps.setString(3, email);
            ps.setString(4, passwordHash);
            ps.setString(5, telefono);
            ps.executeUpdate();

            response.sendRedirect("login.jsp?msg=Registrazione avvenuta con successo");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("registrati.jsp?error=Errore durante la registrazione");
        }
    }
}


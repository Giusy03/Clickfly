package com.clickfly.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clickfly.dao.PrenotazioneDAO;
import com.clickfly.model.Prenotazione;
import com.clickfly.model.Utente;

@WebServlet("/prenotazioni")
public class PrenotazioniServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Utente utente = (Utente) session.getAttribute("utente");

        if (utente == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            PrenotazioneDAO dao = new PrenotazioneDAO();
            List<Prenotazione> lista = dao.getByUtente(utente.getId());

            request.setAttribute("prenotazioni", lista);
            request.getRequestDispatcher("prenotazioni.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("utente.jsp?error=Errore caricamento prenotazioni");
        }
    }
}


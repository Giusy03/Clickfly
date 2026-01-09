package com.clickfly.servlets;

import com.clickfly.dao.PrenotazioneDAO;
import com.clickfly.dao.UtenteDAO;
import com.clickfly.model.CarrelloItem;
import com.clickfly.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utente utente = (Utente) session.getAttribute("utente");
        List<CarrelloItem> carrello = (List<CarrelloItem>) session.getAttribute("carrello");

        if (utente == null || carrello == null || carrello.isEmpty()) {
            response.sendRedirect("carrello.jsp");
            return;
        }

        BigDecimal totale = BigDecimal.ZERO;
        for (CarrelloItem item : carrello) {
            BigDecimal prezzoItem = item.getPrezzo().multiply(new BigDecimal(item.getQuantita()));
            totale = totale.add(prezzoItem);
        }

        if (utente.getSaldo().compareTo(totale) < 0) {
            response.sendRedirect("carrello.jsp?error=Saldo insufficiente");
            return;
        }

        try {
            BigDecimal nuovoSaldo = utente.getSaldo().subtract(totale);
            UtenteDAO utenteDAO = new UtenteDAO();
            utenteDAO.aggiornaSaldo(utente.getId(), nuovoSaldo);

            utente.setSaldo(nuovoSaldo); 

            PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();

            for (CarrelloItem item : carrello) {
                BigDecimal prezzoTot = item.getPrezzo().multiply(new BigDecimal(item.getQuantita()));

                prenotazioneDAO.creaPrenotazione(
                        utente.getId(),
                        item.getVoloId(),
                        item.getQuantita(),
                        prezzoTot
                );
            }

            session.removeAttribute("carrello");

            response.sendRedirect("prenotazioni.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("carrello.jsp?error=Errore durante il checkout");
        }
    }
}


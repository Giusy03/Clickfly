package com.clickfly.servlets;

import com.clickfly.model.CarrelloItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/aggiungi-carrello")
public class AggiungiAlCarrelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("utente") == null) {
            response.sendRedirect("login.jsp?error=Devi effettuare il login");
            return;
        }

        int voloId = Integer.parseInt(request.getParameter("id"));
        String descrizione = request.getParameter("descrizione");
        String compagnia = request.getParameter("compagnia");
        BigDecimal prezzo = new BigDecimal(request.getParameter("prezzo"));

        List<CarrelloItem> carrello =
                (List<CarrelloItem>) session.getAttribute("carrello");

        if (carrello == null) {
            carrello = new ArrayList<>();
        }

        boolean trovato = false;
        for (CarrelloItem item : carrello) {
            if (item.getVoloId() == voloId) {
                item.incrementaQuantita();
                trovato = true;
                break;
            }
        }

        if (!trovato) {
            carrello.add(new CarrelloItem(voloId, descrizione, compagnia, prezzo));
        }

        session.setAttribute("carrello", carrello);
        response.sendRedirect("carrello.jsp");
    }
}

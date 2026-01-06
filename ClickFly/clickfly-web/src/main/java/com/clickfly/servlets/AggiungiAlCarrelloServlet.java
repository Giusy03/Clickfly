package com.clickfly.servlets;

import com.clickfly.model.CarrelloItem;
import com.clickfly.model.Volo;
import com.clickfly.dao.VoloDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/aggiungi-al-carrello")
public class AggiungiAlCarrelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("utente") == null) {
            response.sendRedirect("login.jsp?error=Devi effettuare il login per aggiungere al carrello");
            return;
        }

        int idVolo = Integer.parseInt(request.getParameter("idVolo"));

        Volo volo = VoloDAO.getById(idVolo);

        if (volo == null) {
            response.sendRedirect("search.jsp?error=Volo non trovato");
            return;
        }

        List<CarrelloItem> carrello = (List<CarrelloItem>) session.getAttribute("carrello");

        if (carrello == null) {
            carrello = new ArrayList<>();
        }

        boolean trovato = false;
        for (CarrelloItem item : carrello) {
            if (item.getVoloId() == idVolo) {
                item.incrementaQuantita();
                trovato = true;
                break;
            }
        }

        if (!trovato) {
            String descrizione = volo.getCittaPartenza() + " → " + volo.getCittaArrivo();

            CarrelloItem nuovo = new CarrelloItem(
                volo.getId(),
                descrizione,
                volo.getCompagnia(),
                volo.getPrezzo()
            );

            carrello.add(nuovo);
        }

        session.setAttribute("carrello", carrello);

        response.sendRedirect("carrello.jsp");
    }
}

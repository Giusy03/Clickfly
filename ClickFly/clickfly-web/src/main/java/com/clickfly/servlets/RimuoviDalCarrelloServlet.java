package com.clickfly.servlets;

import com.clickfly.model.CarrelloItem;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/rimuovi-dal-carrello")
public class RimuoviDalCarrelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("utente") == null) {
            response.sendRedirect("login.jsp?error=Devi effettuare il login per modificare il carrello");
            return;
        }

        List<CarrelloItem> carrello = (List<CarrelloItem>) session.getAttribute("carrello");
        if (carrello == null) {
            response.sendRedirect("carrello.jsp");
            return;
        }

        String idParam = request.getParameter("id");
        if (idParam != null) {
            int idVolo = Integer.parseInt(idParam);

            carrello.removeIf(item -> item.getVoloId() == idVolo);

            session.setAttribute("carrello", carrello);
        }

        response.sendRedirect("carrello.jsp");
    }
}


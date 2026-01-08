package com.clickfly.servlets;

import com.clickfly.dao.UtenteDAO;
import com.clickfly.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/ricarica-saldo")
public class RicaricaSaldoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utente utente = (Utente) session.getAttribute("utente");

        if (utente == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            BigDecimal importo = new BigDecimal(request.getParameter("importo"));

            if (importo.compareTo(BigDecimal.ZERO) <= 0) {
                response.sendRedirect("utente.jsp?error=Importo non valido");
                return;
            }

            BigDecimal nuovoSaldo = utente.getSaldo().add(importo);

            UtenteDAO dao = new UtenteDAO();
            dao.aggiornaSaldo(utente.getId(), nuovoSaldo);

            utente.setSaldo(nuovoSaldo);
            session.setAttribute("utente", utente);

            response.sendRedirect("utente.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("utente.jsp?error=Errore nella ricarica");
        }
    }
}


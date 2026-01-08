package com.clickfly.servlets;

import com.clickfly.dao.UtenteDAO;
import com.clickfly.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordHash = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);

        try {
            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = utenteDAO.login(email, passwordHash);

            if (utente != null) {
                HttpSession session = request.getSession();
                session.setAttribute("utente", utente);
                response.sendRedirect("utente.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Email o password non corretti");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=Errore nel login");
        }
    }
}

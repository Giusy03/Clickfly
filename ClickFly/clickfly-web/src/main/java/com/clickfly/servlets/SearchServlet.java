package com.clickfly.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recupero parametri dalla pagina search.jsp
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String date = request.getParameter("date");
        String passengers = request.getParameter("passengers");

        // Per ora non abbiamo il DB: creiamo risultati finti (mock)
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("date", date);
        request.setAttribute("passengers", passengers);

        // In futuro qui chiameremo il DAO per ottenere i voli reali

        RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("risultati.jsp");
        rd.forward(request, response);
    }
}


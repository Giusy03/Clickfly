package com.clickfly.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // qui puoi recuperare offerte, prodotti, dati dal DB in futuro
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}


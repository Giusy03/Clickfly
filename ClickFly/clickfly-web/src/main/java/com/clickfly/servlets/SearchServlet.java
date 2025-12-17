package com.clickfly.servlets;

import com.clickfly.dao.VoloDAO;
import com.clickfly.model.Volo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private VoloDAO voloDAO = new VoloDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String dateStr = request.getParameter("date");

        try {
            Date data = Date.valueOf(dateStr);
            List<Volo> voli = voloDAO.cercaVoli(from, to, data);

            request.setAttribute("voli", voli);
            request.getRequestDispatcher("risultati.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}


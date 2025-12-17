package com.clickfly.servlets;

import com.clickfly.util.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/test-db")
public class TestDBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try (Connection con = DBManager.getConnection()) {
            resp.getWriter().println("CONNESSIONE OK!");
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}


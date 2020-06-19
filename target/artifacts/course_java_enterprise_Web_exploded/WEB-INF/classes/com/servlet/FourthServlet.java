package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FourthServlet", urlPatterns = {"/send-name"})
public class FourthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        session.setAttribute("name", name);
        session.setAttribute("surname", surname);

        writer.write("<p>Person set in session: " + session.getAttribute("name").toString()
                + " " + session.getAttribute("surname").toString() + "</p>");

    }
}

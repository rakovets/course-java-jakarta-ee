package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet", urlPatterns = {"/second-servlet"})
public class SecondServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phone");
        String email = req.getParameter("email");

        writer.write("<p>Your name: " + name + "</p>");
        writer.write("<p>Your phone number: " + phoneNumber + "</p>");
        writer.write("<p>Your email: " + email + "</p>");
    }
}

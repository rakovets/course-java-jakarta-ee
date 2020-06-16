package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", urlPatterns = {"/first-servlet"})
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String userName = req.getParameter("username");
        String userLastName = req.getParameter("userlastname");

        if (userName.length() == 0 && userLastName.length() == 0) {
            writer.write("<p>Wrong request. Don't exist 2 parameters: userName, userLastName</p>");
        } else if (userName.length() == 0 && userLastName.length() != 0) {
            writer.write("<p>Wrong request. Don't exist 1 parameter: userName</p>");
        } else if (userName.length() != 0 && userLastName.length() == 0) {
            writer.write("<p>Wrong request. Don't exist 1 parameter: userLastName</p>");
        } else {
            writer.write("<p>Your name: " + userName + "</p>");
            writer.write("<p>Your last name: " + userLastName + "</p>");
        }
    }
}

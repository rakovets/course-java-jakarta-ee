package com.rakovets.course_java_enterprise.solution.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/names")
public class RequestGetParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (firstName == null || lastName == null) {
            writer.write("One of the names is not specified!");
        } else {
            writer.write(firstName + " " + lastName);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String firstName = reader.readLine();
        String lastName = reader.readLine();

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (firstName == null || lastName == null) {
            writer.write("One of the names is not specified!");
        } else {
            writer.write(firstName + " " + lastName);
        }
    }
}

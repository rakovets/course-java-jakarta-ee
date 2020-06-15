package com;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task01")

public class Task01 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("nameTask01");
        String surname = req.getParameter("surname");
        if (name.length() == 0 & surname.length() == 0) {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write(getTextError("name, surname"));
        } else if(name.length() == 0) {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write(getTextError("name"));
        } else if(surname.length() == 0) {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write(getTextError("surname"));
        } else {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 72px; font-family: Aria; " +
                    "font-weight: bold; } </style></head><body><p>" + name + " " + surname + "<p/></body>");
        }
    }

    private String getTextError(String parameters) {
        return "<head><style type=\"text/css\"> p { color: red; font-size: 32px; font-family: Aria; " +
                "font-weight: bold; } </style></head><body><p>Wrong request. <br>Don't exists: " +
                "<span style='color: black;'>" + parameters + "</span><p/></body>";
    }
}
package com;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task02")

public class Task02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("nameTask02");
        String phone = req.getParameter("phone");
        String mail = req.getParameter("mail");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
                "font-weight: bold; } </style></head><body><p>Name: " + name + "<br>Phone: " + phone +
                "<br>Mail: " + mail + "<p/></body>");
    }
}

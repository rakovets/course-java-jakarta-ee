package com;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task03")

public class Task03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String infoBrowser = req.getHeader("User-Agent");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
                "font-weight: bold; } </style></head><body><p>Hi user using browser: <span style='color: black;'>" +
                infoBrowser + "</span><p/></body>");
    }
}

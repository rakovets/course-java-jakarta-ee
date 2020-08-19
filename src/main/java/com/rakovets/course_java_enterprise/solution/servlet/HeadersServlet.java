package com.rakovets.course_java_enterprise.solution.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/agent")
public class HeadersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAgent = req.getHeader("User-Agent");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (userAgent.contains("Chrome")) {
            writer.write("Приветствую пользователя Chrome");
        } else if (userAgent.contains("Firefox")) {
            writer.write("Приветствую пользователя Firefox");
        }
    }
}

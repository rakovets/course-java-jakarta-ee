package com.rakovets.course_java_enterprise.solution.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
    private AtomicInteger counter = new AtomicInteger();
    private static final String COOKIE_NAME = "counter-cookie";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        boolean isCookieFound = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(COOKIE_NAME)) {
                    isCookieFound = true;
                    break;
                }
            }
        }

        if (!isCookieFound) {
            counter.incrementAndGet();
            resp.addCookie(new Cookie(COOKIE_NAME, "someValue"));
        }

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<h1 style='color: red;'>" + counter + "</h1>");
    }
}

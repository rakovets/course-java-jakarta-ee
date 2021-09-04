package by.rakovets.course.java.jakarta_ee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

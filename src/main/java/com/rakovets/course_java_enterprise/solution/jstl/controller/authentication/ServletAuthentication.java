package com.rakovets.course_java_enterprise.solution.jstl.controller.authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authentication")
public class ServletAuthentication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("vipId", "VIP001Admin");
        req.getSession().setMaxInactiveInterval(60*60*60);
        req.getRequestDispatcher("/WEB-INF/jsp/authentication/authenticationSuccess.jsp").forward(req, resp);
    }
}

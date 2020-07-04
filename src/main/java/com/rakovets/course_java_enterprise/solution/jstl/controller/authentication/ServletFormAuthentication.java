package com.rakovets.course_java_enterprise.solution.jstl.controller.authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/formAuthentication")
public class ServletFormAuthentication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if ((session.getAttribute("vipId") != null) && session.getAttribute("vipId").equals("VIP001Admin")) {
            req.getRequestDispatcher("/WEB-INF/jsp/authentication/authenticationSuccess.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/authentication/formAuthentication.jsp").forward(req, resp);
        }
    }
}

package com.rakovets.course_java_enterprise.solution.jstl.controller.locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/localeChange")
public class ServletLocaleChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String localeName = req.getParameter("locale");
        resp.setCharacterEncoding("UTF-8");
        if (localeName.equals("English")) {
            setAttribute(req, "en", "US");
        }
        if (localeName.equals("France")) {
            setAttribute(req, "fr", "FR");
        }
        if (localeName.equals("Germany")) {
            setAttribute(req, "de", "DE");
        }
        if (localeName.equals("Russian")) {
            setAttribute(req, "ru", "RU");
        }
        req.getRequestDispatcher(req.getParameter("referrer")).forward(req, resp);
    }

    private void setAttribute(HttpServletRequest req, String language, String country) {
        Locale locale = new Locale(language, country);
        ResourceBundle bundle = ResourceBundle.getBundle("translations", locale);
        req.getSession().setAttribute("abilities", bundle.getString("abilities"));
        req.getSession().setAttribute("heroes", bundle.getString("heroes"));
        req.getSession().setAttribute("create", bundle.getString("create"));
    }
}

package com.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DataForwardServlet", urlPatterns = {"/data-forward"})
public class DataForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "WEB-INF/jsp/data-forward.jsp";
        req.setAttribute("firstName", "Mark");
        req.setAttribute("lastName", "Twen");
        req.setAttribute("role", "User");
        req.getRequestDispatcher(path).forward(req, resp);
    }
}

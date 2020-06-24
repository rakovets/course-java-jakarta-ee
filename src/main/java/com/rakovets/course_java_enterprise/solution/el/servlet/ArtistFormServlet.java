package com.rakovets.course_java_enterprise.solution.el.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ArtistFormServlet", urlPatterns = {"/artist/create"})
public class ArtistFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/WEB-INF/jsp/create-artist.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
}

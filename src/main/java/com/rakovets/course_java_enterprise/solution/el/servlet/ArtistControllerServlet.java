package com.rakovets.course_java_enterprise.solution.el.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "ArtistControllerServlet", urlPatterns = {"/artist/artist"})
public class ArtistControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathToArtistCreateSuccess = "/WEB-INF/jsp/create-artist-success.jsp";
        String pathToFormArtist = "/WEB-INF/jsp/create-artist.jsp";

        if (req.getParameter("name").isEmpty() || req.getParameter("russian") == null) {
            req.getRequestDispatcher(pathToFormArtist).forward(req, resp);
        } else {
            req.getRequestDispatcher(pathToArtistCreateSuccess).forward(req, resp);
        }
    }
}

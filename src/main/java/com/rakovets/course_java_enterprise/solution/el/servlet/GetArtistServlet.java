package com.rakovets.course_java_enterprise.solution.el.servlet;

import com.rakovets.course_java_enterprise.solution.el.dto.ArtistDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetArtistServlet", urlPatterns = {"/artist/1"})
public class GetArtistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArtistDto artist = new ArtistDto();
        artist.setId(1);
        artist.setName("Nick Cave");
        artist.setRussian(false);

        req.setAttribute("id", artist.getId());
        req.setAttribute("name", artist.getName());
        req.setAttribute("russian", artist.isRussian());

        String path = "/WEB-INF/jsp/read-artist.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
}

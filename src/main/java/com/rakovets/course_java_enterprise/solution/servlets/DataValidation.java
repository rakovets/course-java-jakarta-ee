package main.java.com.rakovets.course_java_enterprise.solution.servlets;

import main.java.com.rakovets.course_java_enterprise.solution.entity.ArtistDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/artist")
public class DataValidation extends HttpServlet {
    boolean russianMusic;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("name").length() == 0 || req.getParameter("option") == null) {
            req.getRequestDispatcher("/WEB-INF/jsp/create-artist.jsp").forward(req, resp);
        } else {

            if (req.getParameter("option").equals("true")) {
                russianMusic = true;
            } else {
                russianMusic = false;
            }
            ArtistDto artistDto = new ArtistDto(req.getParameter("name"), russianMusic);
            req.getSession().setAttribute("id", req.getSession().getAttribute("id") == null ?
                    1 : (Integer) req.getSession().getAttribute("id") + 1);
            artistDto.setId((Integer) req.getSession().getAttribute("id"));

            ArrayList artistsList = jakarta.el.instanceObject.InstanceObject.getInstanceArtistsList();
            artistsList.add(artistDto);
            artistDto.setArtistsList(artistsList);

            req.getSession().setAttribute("listArtistsSession", artistDto.getArtistsList());
            req.getRequestDispatcher("/WEB-INF/jsp/create-artist-success.jsp").forward(req, resp);
        }
    }
}

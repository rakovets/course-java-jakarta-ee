package com.rakovets.course_java_enterprise.solution.el;

import com.rakovets.course_java_enterprise.solution.el.dto.ArtistDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/jstl")
public class JstlDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookName", "My book");
        List<ArtistDto> artists = new ArrayList<>();
        artists.add(new ArtistDto(1, "Bon Jovi", true));
        artists.add(new ArtistDto(2, "Sting", true));
        req.setAttribute("artists", artists);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/jstl-demo.jsp").forward(req, resp);
    }
}

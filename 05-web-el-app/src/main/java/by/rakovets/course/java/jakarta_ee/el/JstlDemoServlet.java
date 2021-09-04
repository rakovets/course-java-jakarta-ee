package by.rakovets.course.java.jakarta_ee.el;

import by.rakovets.course.java.jakarta_ee.el.dto.ArtistDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

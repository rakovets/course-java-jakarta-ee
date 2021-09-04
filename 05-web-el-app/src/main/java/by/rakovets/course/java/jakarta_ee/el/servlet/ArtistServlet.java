package by.rakovets.course.java.jakarta_ee.el.servlet;

import by.rakovets.course.java.jakarta_ee.el.dto.ArtistDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/read-artist.jsp");
        long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("artist", new ArtistDto(id, "Eminem", false));
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("artistName");
        String russian = req.getParameter("russian");
        String jspName = name.equals("") ? "create-artist.jsp" : "create-artist-success.jsp";
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.forward(req, resp);
    }
}

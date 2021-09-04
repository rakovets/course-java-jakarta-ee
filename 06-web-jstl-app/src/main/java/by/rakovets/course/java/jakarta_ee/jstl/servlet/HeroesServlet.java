package by.rakovets.course.java.jakarta_ee.jstl.servlet;

import by.rakovets.course.java.jakarta_ee.jstl.service.HeroService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/heroes")
public class HeroesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("heroes", HeroService.getInstance().getAllHeroes());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/read-heroes.jsp").forward(req, resp);
    }
}

package by.rakovets.course.java.jakarta_ee.jstl.servlet;

import by.rakovets.course.java.jakarta_ee.jstl.service.AbilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/abilities")
public class AbilitiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("abilities", AbilityService.getInstance().getAllAbilities());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/read-abilities.jsp").forward(req, resp);
    }
}

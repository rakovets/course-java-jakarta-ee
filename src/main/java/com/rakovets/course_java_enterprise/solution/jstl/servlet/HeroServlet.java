package com.rakovets.course_java_enterprise.solution.jstl.servlet;

import com.rakovets.course_java_enterprise.solution.jstl.dao.AbilityDao;
import com.rakovets.course_java_enterprise.solution.jstl.dto.CreateNewHeroDto;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Gender;
import com.rakovets.course_java_enterprise.solution.jstl.service.HeroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hero")
public class HeroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hero", HeroService.getInstance().getFullInfo(Integer.parseInt(req.getParameter("id"))));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/read-hero.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewHeroDto createNewHeroDto = new CreateNewHeroDto(
                req.getParameter("name"),
                req.getParameter("identity"),
                Integer.parseInt(req.getParameter("age")),
                Gender.valueOf(req.getParameter("gender")),
                Long.parseLong(req.getParameter("ability"))
        );
        HeroService.getInstance().createNewHero(createNewHeroDto);
        req.setAttribute("abilities", AbilityDao.getInstance().findAll());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/create-hero.jsp").forward(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("abilities", AbilityDao.getInstance().findAll());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/create-hero.jsp").forward(req, resp);
    }

    private CreateNewHeroDto transformRequestData(HttpServletRequest request) {
        return new CreateNewHeroDto(
                request.getParameter("name"),
                request.getParameter("identity"),
                Integer.parseInt(request.getParameter("age")),
                Gender.valueOf(request.getParameter("gender")),
                Long.parseLong(request.getParameter("ability"))
        );
    }
}

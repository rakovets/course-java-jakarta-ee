package com.rakovets.course_java_enterprise.solution.jstl.servlet;

import com.rakovets.course_java_enterprise.solution.jstl.dto.ViewHeroFullInfoDto;
import com.rakovets.course_java_enterprise.solution.jstl.service.HeroService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long heroId = Long.parseLong(req.getParameter("heroId"));
        ViewHeroFullInfoDto optionalHero = HeroService.getInstance().getFullInfo(heroId);
        req.getSession().setAttribute("optionalHero", optionalHero);
        req.getRequestDispatcher("/WEB-INF/jsp/read-hero.jsp").forward(req, resp);
    }
}

package com.rakovets.course_java_enterprise.solution.jstl.controller;

import com.rakovets.course_java_enterprise.solution.jstl.dto.ViewHeroBasicInfoDto;
import com.rakovets.course_java_enterprise.solution.jstl.service.HeroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/heroesServlet")
public class HeroesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ViewHeroBasicInfoDto> heroesList = HeroService.getInstance().getAllHeroes();
        req.getSession().setAttribute("heroesList", heroesList);
        req.getRequestDispatcher("/WEB-INF/jsp/read-heroes.jsp").forward(req, resp);
    }
}

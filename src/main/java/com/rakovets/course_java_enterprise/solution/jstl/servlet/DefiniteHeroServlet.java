package com.rakovets.course_java_enterprise.solution.jstl.servlet;

import com.rakovets.course_java_enterprise.solution.jstl.dto.ViewHeroFullInfoDto;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Hero;
import com.rakovets.course_java_enterprise.solution.jstl.service.HeroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DefiniteHeroServlet", urlPatterns = {"/definite-hero"})
public class DefiniteHeroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long heroId = Long.parseLong(req.getParameter("heroId"));
        ViewHeroFullInfoDto fullInfoHero = HeroService.getInstance().getFullInfo(heroId);
        req.setAttribute("fullInfoHero", fullInfoHero);
        String path = "/WEB-INF/jsp/definite-hero.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
}

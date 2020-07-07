package com.rakovets.course_java_enterprise.solution.jstl.servlet;

import com.rakovets.course_java_enterprise.solution.jstl.dto.ViewHeroBasicInfoDto;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Hero;
import com.rakovets.course_java_enterprise.solution.jstl.service.HeroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HeroServlet", urlPatterns = {"/heroes"})
public class HeroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ViewHeroBasicInfoDto> viewHeroBasicInfoDtoList = HeroService.getInstance().getAllHeroes();
        req.setAttribute("heroes", viewHeroBasicInfoDtoList);
        String path = "/WEB-INF/jsp/heroes.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
}

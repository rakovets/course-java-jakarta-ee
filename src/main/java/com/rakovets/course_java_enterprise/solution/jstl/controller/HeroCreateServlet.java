package com.rakovets.course_java_enterprise.solution.jstl.controller;

import com.rakovets.course_java_enterprise.solution.jstl.dto.CreateNewHeroDto;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Gender;
import com.rakovets.course_java_enterprise.solution.jstl.service.HeroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/heroCreateServlet")
public class HeroCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gender gender;
       if (req.getParameter("option").equals("MALE")) {
           gender = Gender.MALE;
       } else {
           gender = Gender.FEMALE;
       }
        CreateNewHeroDto createNewHeroDto =  new CreateNewHeroDto(req.getParameter("name"),
              req.getParameter("identity"), Integer.parseInt(req.getParameter("age")), gender,
              Long.parseLong(req.getParameter("ability")));
        HeroService.getInstance().createNewHero(createNewHeroDto);
        req.setAttribute("heroName", req.getParameter("name"));
        req.getRequestDispatcher("/WEB-INF/jsp/create-hero-success.jsp").forward(req, resp);
    }
}

package com.rakovets.course_java_enterprise.solution.jstl.servlet;

import com.rakovets.course_java_enterprise.solution.jstl.dto.CreateNewHeroDto;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Gender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProcessingSaveHeroServlet", urlPatterns = {"/save-hero"})
public class ProcessingSaveHeroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gender gender;
        if (req.getParameter("abilities").equals("MALE")) {
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }

        CreateNewHeroDto createNewHeroDto = new CreateNewHeroDto(req.getParameter("name"),
                req.getParameter("identity"), Integer.parseInt(req.getParameter("age")),
                gender, Long.parseLong(req.getParameter("abilities")));

        String path = "/WEB-INF/jsp/result-of-create-hero.jsp";
        req.setAttribute("savedHero", createNewHeroDto);
        req.getRequestDispatcher(path).forward(req, resp);
    }
}

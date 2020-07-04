package com.rakovets.course_java_enterprise.solution.jstl.controller;

import com.rakovets.course_java_enterprise.solution.jstl.entity.Ability;
import com.rakovets.course_java_enterprise.solution.jstl.service.AbilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/abilitiesServlet")
public class AbilitiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ability> abilityList = AbilityService.getInstance().getAllAbilities();
        req.getSession().setAttribute("abilitiesList", abilityList);
        req.getRequestDispatcher("/WEB-INF/jsp/read-abilities.jsp").forward(req, resp);
    }
}

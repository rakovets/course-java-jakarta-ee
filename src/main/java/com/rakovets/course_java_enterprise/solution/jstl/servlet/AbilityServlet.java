package com.rakovets.course_java_enterprise.solution.jstl.servlet;

import com.rakovets.course_java_enterprise.solution.jstl.entity.Ability;
import com.rakovets.course_java_enterprise.solution.jstl.service.AbilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AbilityServlet", urlPatterns = {"/abilities"})
public class AbilityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ability> abilities = AbilityService.getInstance().getAllAbilities();
        req.setAttribute("abilities", abilities);
        String path = "/WEB-INF/jsp/abilities.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
}

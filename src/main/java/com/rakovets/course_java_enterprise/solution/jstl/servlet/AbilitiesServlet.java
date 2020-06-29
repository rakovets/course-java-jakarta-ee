package com.rakovets.course_java_enterprise.solution.jstl.servlet;

import com.rakovets.course_java_enterprise.solution.jstl.dao.AbilityDao;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Ability;
import com.rakovets.course_java_enterprise.solution.jstl.service.AbilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet({"read-abilities.jsp"})
public class AbilitiesServlet extends HttpServlet {

    AbilityDao abilityDao = AbilityDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ability> abilityList = AbilityService.getInstance().getAllAbilities();
        req.setAttribute("abilities", abilityList);
        req.setAttribute("jop", "jop start");
        req.getRequestDispatcher("/WEB-INF/jsp/read-abilities.jsp").forward(req, resp);
    }
}

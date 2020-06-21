package main.java.com.rakovets.course_java_enterprise.solution.servlet;

import main.java.com.rakovets.course_java_enterprise.solution.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DataForwardServlet", urlPatterns = {"/data-forward"})
public class DataForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("firstName"), req.getParameter("lastName"));
        req.setAttribute("role", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/data-forward.jsp");
        dispatcher.forward(req, resp);
    }
}

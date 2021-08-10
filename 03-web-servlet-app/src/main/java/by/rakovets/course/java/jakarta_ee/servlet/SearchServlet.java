package by.rakovets.course.java.jakarta_ee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Search servlet received request");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<h1 style=\"text-align: center;\">Search request processed!</h1>");
    }
}

package by.rakovets.course.java.jakarta_ee.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/example/jsp/without")
public class ProcessWithoutJspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("header", "Apache Tomcat");
        // code
        String view = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <title>First JSP App</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h2>" + req.getAttribute("header") + "</h2>\n" +
                "    <p>Today " + new java.util.Date() + "</p>\n" +
                "</body>\n" +
                "</html>";
        PrintWriter writer = resp.getWriter();
        writer.write(view);
    }
}

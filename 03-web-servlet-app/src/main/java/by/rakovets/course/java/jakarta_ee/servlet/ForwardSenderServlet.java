package by.rakovets.course.java.jakarta_ee.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/sender")
public class ForwardSenderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>Sender got message</h1>");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/receiver");
        writer.write("<h1>Sender forwarded message</h1>");
        requestDispatcher.forward(req, resp);
        writer.write("<h1>Sender continued working</h1>");
    }
}

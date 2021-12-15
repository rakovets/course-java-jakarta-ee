package by.rakovets.course.java.jakarta_ee.servlet.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/example/reader/body")
public class HttpRequestBodyReaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String htmlPage = "";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String firstName = reader.readLine();
        String lastName = reader.readLine();

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (firstName == null || lastName == null) {
            writer.write("One of the names is not specified!");
        } else {
            writer.write(firstName + " " + lastName);
        }
    }
}

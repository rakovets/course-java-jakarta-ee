package by.rakovets.course.java.jakarta_ee.servlet.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/example/reader/headers")
public class HttpHeadersReaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getHeaderNames();

        StringBuilder sb = new StringBuilder();

        while (parameterNames.hasMoreElements()) {
            String headerName = parameterNames.nextElement();
            sb.append("\t\"")
                    .append(headerName)
                    .append("\": \"")
                    .append(req.getHeader(headerName))
                    .append("\",\n");
        }
        String bodyAsJson = (sb.length() == 2)
                ? "{}"
                : "{\n" + sb.substring(0, sb.length() - 2) + "\n}";

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(bodyAsJson);
    }
}

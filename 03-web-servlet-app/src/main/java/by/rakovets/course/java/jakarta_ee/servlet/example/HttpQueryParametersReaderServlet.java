package by.rakovets.course.java.jakarta_ee.servlet.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/example/reader/query-params")
public class HttpQueryParametersReaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getParameterNames();

        StringBuffer sb = new StringBuffer();
        sb.append("{\n");

        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            sb.append("\t\"")
                    .append(parameterName)
                    .append("\": \"")
                    .append(req.getParameter(parameterName))
                    .append("\",\n");
        }
        String bodyAsJson = (sb.length() == 2)
                ? "{}"
                : sb.substring(0, sb.length() - 2) + "\n}";

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(bodyAsJson);
    }
}

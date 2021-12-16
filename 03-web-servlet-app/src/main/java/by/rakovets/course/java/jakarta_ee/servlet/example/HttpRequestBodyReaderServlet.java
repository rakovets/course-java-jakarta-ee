package by.rakovets.course.java.jakarta_ee.servlet.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;


@WebServlet("/example/reader/body")
public class HttpRequestBodyReaderServlet extends HttpServlet {
    public static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    public static final String CONTENT_TYPE_TEXT_HTML = "text/html";
    public static final String QUERY_PARAMETER_ENCTYPE = "enctype";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enctype = (req.getParameter(QUERY_PARAMETER_ENCTYPE) == null || req.getParameter(QUERY_PARAMETER_ENCTYPE).isEmpty())
                ? APPLICATION_X_WWW_FORM_URLENCODED
                : MULTIPART_FORM_DATA;

        String view = getUserFormView(req.getRequestURI(), enctype);

        resp.setContentType(CONTENT_TYPE_TEXT_HTML);
        PrintWriter writer = resp.getWriter();
        writer.write(view);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (APPLICATION_X_WWW_FORM_URLENCODED.equals(req.getHeader(HEADER_CONTENT_TYPE)))
                ? processFormUrlEncoded(req)
                : processMultiPartFormData(req);

        String view = (user.getFirstName() == null || user.getLastName() == null)
                ? getErrorView()
                : getUserView(user);

        resp.setContentType(CONTENT_TYPE_TEXT_HTML);
        PrintWriter writer = resp.getWriter();
        writer.write(view);
    }

    static class User {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    private User processFormUrlEncoded(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        return user;
    }

    private User processMultiPartFormData(HttpServletRequest req) throws IOException {
        User user = new User();
        BufferedReader reader = req.getReader();
        String content = reader.lines()
                .collect(Collectors.joining("\n"));

        //TODO parsing
        return user;
    }

    private String getErrorView() {
        return "One of the names is not specified!";
    }

    private String getUserView(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }

    private String getUserFormView(String urlPattern, String enctype) {
        return "<form action=\"" + urlPattern + "\" method=\"post\" enctype=\"" + enctype + "\">\n" +
                "    <label>Enter firstname:\n" +
                "        <input name=\"firstName\" type=\"text\">\n" +
                "    </label><br>\n" +
                "    <label>Enter lastname:\n" +
                "        <input name=\"lastName\" type=\"text\">\n" +
                "    </label><br>\n" +
                "    <input type=\"submit\"><br>\n" +
                "</form>";
    }
}

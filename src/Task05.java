import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Task05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String DATASOURSE_URL = "jdbc:mysql://localhost:3306/restaurant?useUnicode=true&serverTimezone=UTC";
        final String DATASOURSE_USER = "root";
        final String DATASOURSE_PASSWORD = "root";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Set Parameters";
        String id = request.getParameter("entityID");
        String name = request.getParameter("nameEntity");
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType +
                "<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " + title +
                "font-weight: bold; } </style></head><body><p>ID: " + id + "<br>Name: " + name + "<p/>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DATASOURSE_URL, DATASOURSE_USER, DATASOURSE_PASSWORD);
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO restaurant.restaurant (name) VALUE (?)"
                            , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getParameter("nameEntity"));
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                resultSet.getLong(1);
            }
            while (resultSet.next()) {
                out.println("<p> You add Restaurant by ID: " + request.getParameter("entityID")
                        + "You add Restaurant by Name: " + request.getParameter("nameEntity") + "<p/>");
            }

            out.println("</body></html>");
            resultSet.close();
            preparedStatement.close();
            conn.close();

        } catch (SQLException se) {
            System.out.println("SQLException" + se);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }
}

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class DatabaseAccess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String DATASOURSE_URL = "jdbc:mysql://localhost:3306/restaurant?useUnicode=true&serverTimezone=UTC";
        final String DATASOURSE_USER = "root";
        final String DATASOURSE_PASSWORD = "root";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        String id = request.getParameter("entityID");
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType +
                "<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " + title +
                "font-weight: bold; } </style></head><body><p>EntityID: " + id + "<p/></body>");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DATASOURSE_URL, DATASOURSE_USER, DATASOURSE_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM restaurant WHERE restaurant.id = " + request.getParameter("entityID"));
            while (resultSet.next()) {

                int idRestaurant = resultSet.getInt("id");
                String nameRestaurant = resultSet.getString("name");
                out.println("Restaurant ID: " + idRestaurant + "<br>");
                out.println("Restaurant Name: " + nameRestaurant + "<br>");

            }
            out.println("</body></html>");
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQLException" + se);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }
}

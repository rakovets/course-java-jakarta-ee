package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ForwardServlet", urlPatterns = "/forward-servlet")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        try {
            String DATASOURCE_DRIVER = "com.mysql.jdbc.Driver";
            String DATASOURCE_URL = "jdbc:mysql://localhost/restaurant?serverTimezone=Europe/Minsk&useSSL=false";
            String DATASOURCE_USER = "root";
            String DATASOURCE_PASSWORD = "12340987";
            Class.forName(DATASOURCE_DRIVER);
            try (Connection connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD)) {
                HttpSession session = req.getSession();
                int id = Integer.parseInt(session.getAttribute("id").toString());
                String sql = "SELECT * FROM restaurant WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    writer.write("Restaurant: id - " + resultSet.getInt("id") +
                            " title - " + resultSet.getString("name"));
                }
            } catch (SQLException ex) {
                writer.write("Not connection with database!!");
            }
        } catch (ClassNotFoundException ex) {
            writer.write("Don't find JDBC driver: " + ex);
        }
    }
}

package com.rakovets.course_java_enterprise.solution.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by user on 10.04.2017.
 */
@WebServlet("/db")
public class DbServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/restaurant_business";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<table>");
        writer.write("<th>");
        writer.write("<td>Id</td><td>Name</td>");
        writer.write("</th>");
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM restaurants")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        writer.write("<tr>");
                        writer.write("<td>" + resultSet.getLong("id") + "</td>");
                        writer.write("<td>" + resultSet.getString("name") + "</td>");
                        writer.write("</tr>");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.write("</table>");
    }
}

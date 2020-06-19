package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "SeventhServlet", urlPatterns = {"/entity-to-db"})
public class SeventhServlet extends HttpServlet {
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
                String name = req.getParameter("name");
                String sql = "INSERT INTO restaurant (name) VALUES (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, name);

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                HttpSession session = req.getSession();
                session.setAttribute("id", generatedKeys.getInt(1));

                long count = preparedStatement.executeUpdate();
                writer.write("<p>Restaurant saved. Added: " + count + " line</p>");

                String path = "/forward-servlet";
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
                requestDispatcher.forward(req, resp);
            } catch (SQLException ex) {
                writer.write("Not connection with database!!");
            }
        } catch (ClassNotFoundException ex) {
            writer.write("Don't find JDBC driver: " + ex);
        }
    }
}

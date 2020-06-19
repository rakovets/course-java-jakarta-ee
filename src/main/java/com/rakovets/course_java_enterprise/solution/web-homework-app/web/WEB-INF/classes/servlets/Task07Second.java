package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/task07Second")
public class Task07Second extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		final String DATASOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/restaurant?serverTimezone=Europe/Moscow";
		final String DATASOURCE_USER = "root";
		final String DATASOURCE_PASSWORD = "1234";

		String entityName = req.getParameter("nameRestaurant");
		int id = 0;
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		try {
			Class.forName(DATASOURCE_DRIVER);
		} catch (ClassNotFoundException e) {
			writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
					"font-weight: bold; } </style></head><body><p>Didn't found JDBC Driver: " + DATASOURCE_DRIVER +
					"<p/></body>");
		}
		try(Connection connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD)) {
			Statement statement = connection.createStatement();
			ResultSet resultSetNameRestaurant = statement.executeQuery("SELECT id FROM restaurant\n" +
					"WHERE name = '" + entityName + "'");
			while (resultSetNameRestaurant.next()) {
				id = resultSetNameRestaurant.getInt("id");
			}
			writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
					"font-weight: bold; } </style></head><body><p>Id: " + id + "<br>Name: " + entityName +
					"<p/></body>");
		} catch (SQLException e) {
			writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
					"font-weight: bold; } </style></head><body><p>SQLException: : " + e + "<p/></body>");
		}
	}
}

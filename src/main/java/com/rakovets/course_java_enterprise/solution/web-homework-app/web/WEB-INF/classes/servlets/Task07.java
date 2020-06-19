package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
import java.sql.SQLException;

@WebServlet("/task07")
public class Task07 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		final String DATASOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/restaurant?serverTimezone=Europe/Moscow";
		final String DATASOURCE_USER = "root";
		final String DATASOURCE_PASSWORD = "1234";

		String nameRestaurant = req.getParameter("nameRestaurant");
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
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO restaurant (name) VALUE (?)");
				preparedStatement.setString(1, nameRestaurant);
				preparedStatement.executeUpdate();
		} catch (SQLException e) {
			writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
					"font-weight: bold; } </style></head><body><p>SQLException: : " + e + "<p/></body>");
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/task07Second");
		dispatcher.forward(req, resp);
	}
}

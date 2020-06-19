package servlets;

import entity.Restaurant;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/task06")
public class Task06 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		final String DATASOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/restaurant?serverTimezone=Europe/Moscow";
		final String DATASOURCE_USER = "root";
		final String DATASOURCE_PASSWORD = "1234";

		String entityId = req.getParameter("entityId");
		String name = null;
		List listDishes = new ArrayList();
		List listReviews = new ArrayList();
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
			ResultSet resultSetNameRestaurant = statement.executeQuery("SELECT name FROM restaurant\n" +
					"WHERE id = " + entityId);
			while (resultSetNameRestaurant.next()) {
				name = resultSetNameRestaurant.getString("name");
			}
			ResultSet resultSetDishes = statement.executeQuery("SELECT rest.id, rest.name, d.name AS 'dishes'\n"+
					"FROM restaurant AS rest\n" +
					"JOIN restaurant_dish AS rd ON rd.restaurant_id = rest.id\n" +
					"JOIN dish AS d ON d.id = rd.dish_id\n" +
					"WHERE rest.id = " + entityId);
			while (resultSetDishes.next()) {
				listDishes.add(resultSetDishes.getString("dishes"));
			}
			ResultSet resultSetReviews = statement.executeQuery("SELECT rev.content\n" +
					"FROM restaurant AS rest\n" +
					"JOIN restaurant_review AS rr ON rest.id = rr.restaurant_id\n" +
					"JOIN review AS rev ON rr.review_id = rev.id\n" +
					"WHERE rest.id = " + entityId);
			while (resultSetReviews.next()) {
				listReviews.add(resultSetReviews.getString("content"));
			}
			Restaurant restaurant = new Restaurant(name);
			restaurant.setId(Integer.parseInt(entityId));
			restaurant.setListDish(listDishes);
			restaurant.setListReview(listReviews);
			writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
					"font-weight: bold; } </style></head><body><p>Id: " + restaurant.getId() + "<br>Name: " +
					restaurant.getName() + "<br>Dishes: " + restaurant.getListDish() + "<br>Reviews: " +
					restaurant.getListReview() + "<p/></body>");
		} catch (SQLException e) {
			writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
					"font-weight: bold; } </style></head><body><p>SQLException: : " + e + "<p/></body>");
		}
	}
}

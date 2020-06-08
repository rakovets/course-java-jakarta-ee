package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManager;
import main.java.com.rakovets.course_java_enterprise.solution.dao.RestaurantDao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.instanceObject.InstanceObject;

import java.sql.*;
import java.util.List;

public class RestaurantDaoImpl implements RestaurantDao<Restaurant> {
	@Override
	public Restaurant save(Restaurant restaurant) {
		try {
			Connection connection = ConnectionManager.getConnection();
			System.out.println("\nJDBC connected!");
			try (PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO restaurant (name) VALUE (?)", Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, restaurant.getName());
				preparedStatement.executeUpdate();
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					restaurant.setId(generatedKeys.getInt(1));
				}
				System.out.print("Added new ");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
		return restaurant;
	}

	@Override
	public List<Restaurant> findAll() {
		List listRestaurant = InstanceObject.getInstanceListRestaurant();
		if (!listRestaurant.isEmpty()) {
			listRestaurant.clear();
		}
		try {
			Connection connection = ConnectionManager.getConnection();
			System.out.println("\nJDBC connected!");
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery("SELECT * FROM restaurant ORDER BY id");
				while (resultSet.next()) {
					Restaurant restaurant = new Restaurant(resultSet.getString("name"));
					restaurant.setId(resultSet.getInt("id"));
					listRestaurant.add(restaurant);
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
		return listRestaurant;
	}

	@Override
	public boolean addDishToRestaurant(int restaurantID, int dishID) {
		boolean resultAdd = false;
		try {
			Connection connection = ConnectionManager.getConnection();
			System.out.println("\nJDBC connected!");
			try (PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO restaurant_dish (restaurant_id, dish_id) VALUE (?, ?)")) {
				preparedStatement.setInt(1, restaurantID);
				preparedStatement.setInt(2, dishID);
				preparedStatement.executeUpdate();
				System.out.printf("Added dish ID = %d to restaurant ID = %d - ", dishID, restaurantID);
				resultAdd = true;
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
		return resultAdd;
	}

	@Override
	public Restaurant showRestaurantByID(int restaurantID) {
		Restaurant restaurant = null;
		List listDishes = InstanceObject.getInstanceListDishes();
		List listReviews = InstanceObject.getInstanceListReview();
		if (!listDishes.isEmpty()) {
			listDishes.clear();
		}
		if (!listReviews.isEmpty()) {
			listReviews.clear();
		}
		try {
			Connection connection = ConnectionManager.getConnection();
			System.out.println("\nJDBC connected!");
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSetRestaurant = statement.executeQuery("SELECT * FROM restaurant");
				while (resultSetRestaurant.next()) {
					restaurant = new Restaurant(resultSetRestaurant.getString("name"));
					restaurant.setId(resultSetRestaurant.getInt("id"));
				}

				ResultSet resultSetDishes = statement.executeQuery(
						String.format("SELECT rest.id, rest.name, d.name AS 'dishes'\n" +
						"FROM restaurant AS rest\n" +
						"JOIN restaurant_dish AS rd ON rd.restaurant_id = rest.id\n" +
						"JOIN dish AS d ON d.id = rd.dish_id\n" +
						"WHERE rest.id = %d;", restaurantID));
				while (resultSetDishes.next()) {
					listDishes.add(resultSetDishes.getString("dishes"));
				}
				restaurant.setListDish(listDishes);

				ResultSet resultSetReviews = statement.executeQuery(
						String.format("SELECT rev.content\n" +
								"FROM restaurant AS rest\n" +
								"JOIN restaurant_review AS rr ON rest.id = rr.restaurant_id\n" +
								"JOIN review AS rev ON rr.review_id = rev.id\n" +
								"WHERE rest.id = %d;", restaurantID));
				while (resultSetReviews.next()) {
					listReviews.add(resultSetReviews.getString("content"));
				}
				restaurant.setListReview(listReviews);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
		return restaurant;
	}

	@Override
	public boolean verifyExistenceRestaurantID(int restaurantID) {
		boolean existID = false;
		try {
			Connection connection = ConnectionManager.getConnection();
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery("SELECT * FROM restaurant");
				while (resultSet.next()) {
					if (resultSet.getInt("id") == restaurantID) {
						existID = true;
					}
				}
				if (!existID) {
					System.out.println("ID NOT EXIST");
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
		return existID;
	}
}
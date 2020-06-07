package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManager;
import main.java.com.rakovets.course_java_enterprise.solution.dao.RestaurantDao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;

import java.sql.*;

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
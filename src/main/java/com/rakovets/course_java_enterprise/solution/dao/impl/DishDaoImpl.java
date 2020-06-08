package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManager;
import main.java.com.rakovets.course_java_enterprise.solution.dao.DishDao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.instanceObject.InstanceObject;

import java.sql.*;
import java.util.List;

public class DishDaoImpl implements DishDao<Dish> {

	@Override
	public Dish save(Dish dish) {
		try {
			Connection connection = ConnectionManager.getConnection();
			System.out.println("\nJDBC connected!");
			try (PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO dish (name) VALUE (?)", Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, dish.getName());
				preparedStatement.executeUpdate();
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					dish.setId(generatedKeys.getInt(1));
				}
				System.out.print("Added new ");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
		return dish;
	}

	@Override
	public List<Dish> findAll() {
		List listDishes = InstanceObject.getInstanceListDishes();
		if (!listDishes.isEmpty()) {
			listDishes.clear();
		}
		try {
			Connection connection = ConnectionManager.getConnection();
			System.out.println("\nJDBC connected!");
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery("SELECT * FROM dish ORDER BY id");
				while (resultSet.next()) {
					Dish dish = new Dish(resultSet.getString("name"));
					dish.setId(resultSet.getInt("id"));
					listDishes.add(dish);
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
		return listDishes;
	}

	@Override
	public boolean verifyExistenceDishID(int dishID) {
		boolean existID = false;
		try {
			Connection connection = ConnectionManager.getConnection();
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery("SELECT * FROM dish");
				while (resultSet.next()) {
					if (resultSet.getInt("id") == dishID) {
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
package main.java.com.rakovets.course_java_enterprise.solution.dao.Impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManager;
import main.java.com.rakovets.course_java_enterprise.solution.dao.Dao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;

import java.sql.*;

public class RestaurantDaoImpl implements Dao<Restaurant> {
    private static final Object LOCK = new Object();
    private static RestaurantDaoImpl INSTANCE = null;

    public static RestaurantDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new RestaurantDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO restaurant (name) VALUES (?)",
                            Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, restaurant.getName());

            long count = preparedStatement.executeUpdate();
            System.out.println("Rows added in DB: " + count);
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                restaurant.setId(generatedKeys.getLong(1));
                return restaurant;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public Restaurant find(long id) throws SQLException {
        return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Restaurant restaurant) throws SQLException {
        return false;
    }
}

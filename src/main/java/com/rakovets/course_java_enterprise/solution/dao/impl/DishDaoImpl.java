package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManeger;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;

import java.sql.*;

public class DishDaoImpl implements DishDao<Dish> {

    Connection connection = new ConnectionManeger().createConnection();

    private static final Object LOCK = new Object();

    private static DishDaoImpl INSTANCE = null;

    public static DishDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new DishDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Dish add(Dish dish) throws SQLException {
        Connection connection = ConnectionManeger.createConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO dish (name) VALUE (?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, dish.getName());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            dish.setId(resultSet.getLong(1));
        }
        return dish;
    }

    @Override
    public Dish show(Dish dish) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM dish");
        while (resultSet.next()) {
            System.out.printf("{\n\t\"id\":%d,\n\t\"name\":\"%s\n\t\"",
                    resultSet.getInt("id"), resultSet.getString("name"));
        }
        return dish;
    }

    @Override
    public Dish get(Integer id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM dish WHERE id = " + id);
        while (resultSet.next()) {
            Dish dish = new Dish(resultSet.getString("name"));
            dish.setId(resultSet.getInt("id"));
            return dish;
        }
        return null;
    }
}

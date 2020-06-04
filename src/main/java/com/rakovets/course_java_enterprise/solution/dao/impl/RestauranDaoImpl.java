package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManeger;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restauran;

import java.sql.*;

public class RestauranDaoImpl implements RestaurantDao<Restauran> {

    private static final Object LOCK = new Object();

    private static RestauranDaoImpl INSTANCE = null;

    public static RestauranDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new RestauranDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Restauran add(Restauran restaurant) throws SQLException {
        Connection connection = ConnectionManeger.createConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO restaurant (name) VALUE (?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, restaurant.getName());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            restaurant.setId(resultSet.getLong(1));
        }
        return restaurant;
    }

    @Override
    public Restauran show(Restauran restaurant) throws SQLException {
        Connection connection = ConnectionManeger.createConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM restaurant");
        ResultSet resultSet = preparedStatement.executeQuery();
       if(resultSet.next()){
           restaurant.getId(resultSet.getLong(1));
           System.out.printf("{\n\t\"id\":%d,\n\t\"name\":\"%s\n\t\"",
                   resultSet.getInt("restaurant_id"), resultSet.getString("name"));
       }
        return restaurant;
    }
}

package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManeger;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restauran;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.sql.*;

public class RestauranDaoImpl implements RestaurantDao<Restauran> {

    Connection connection = new ConnectionManeger().createConnection();

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

    public Dish linkDish(int restauranId, int dishId) throws SQLException {
        DishDaoImpl dishDao = DishDaoImpl.getInstance();
        Connection connection = ConnectionManeger.createConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO restaurant_dish (restaurant_id , dish_id) VALUE (? , ?)",
                        Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, restauranId);
        preparedStatement.setInt(2, dishId);
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        return dishDao.get(dishId);
    }

    public Review linkedReview(int restauranId, int reviewId) throws SQLException {
        ReviewDaoImpl reviewDao = ReviewDaoImpl.getInstance();
        Connection connection = ConnectionManeger.createConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO restaurant_review (restaurant_id , review_id) VALUE (? , ?)",
                        Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, restauranId);
        preparedStatement.setInt(2, reviewId);
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        return reviewDao.get(reviewId);
    }

    @Override
    public Restauran show(Restauran restaurant) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM restaurant");
        while (resultSet.next()) {
            System.out.printf("{\n\t\"id\":%d,\n\t\"name\":\"%s\n\t\"",
                    resultSet.getInt("id"), resultSet.getString("name"));
        }
        return restaurant;
    }
}

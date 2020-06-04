package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManeger;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Metd;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.sql.*;

public class ReviewDaoImpl implements ReviewDao<Review> {

    Connection connection = new ConnectionManeger().createConnection();

    private static final Object LOCK = new Object();

    private static ReviewDaoImpl INSTANCE = null;

    public static ReviewDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ReviewDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Review add(Review review) throws SQLException {
        Connection connection = ConnectionManeger.createConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO review (content , restaurant_id ) VALUE (?,?)", Statement.RETURN_GENERATED_KEYS);
        Metd metd = new Metd();
        String askContent = metd.askContent();
        Integer askRestauranId = metd.askRestaurantId();
        preparedStatement.setString(1, askContent);
        preparedStatement.setInt(2, askRestauranId);
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        System.out.printf("Ваша отзыв под названием : %s", askContent + " " + "была успешно дабавлен!!");
        if (resultSet.next()) {
            review.setId(resultSet.getLong(1));
        }
        return review;
    }


    @Override
    public Review show(Review review) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM review");
        while (resultSet.next()) {
            System.out.printf("{\n\t\"id\":%d,\n\t\"content\":\"%s\n\t\"restaurant_id\":\n\t\"",
                    resultSet.getInt("id"), resultSet.getString("content"));
        }
        return review;
    }
}

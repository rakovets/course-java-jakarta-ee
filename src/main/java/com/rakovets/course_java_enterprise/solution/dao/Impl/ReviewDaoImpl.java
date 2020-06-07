package main.java.com.rakovets.course_java_enterprise.solution.dao.Impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManager;
import main.java.com.rakovets.course_java_enterprise.solution.dao.Dao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.sql.*;

public class ReviewDaoImpl implements Dao<Review> {
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
    public Review save(Review review) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("INSERT INTO review (content, restaurant_id) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, review.getContent());
            preparedStatement.setLong(2, review.getRestaurant());

            long count = preparedStatement.executeUpdate();
            System.out.println("Rows added in DB: " + count);
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                review.setId(generatedKeys.getLong(1));
                return review;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Review find(long id) throws SQLException {
        return null;
    }

    @Override
    public Review update(Review review) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Review review) throws SQLException {
        return false;
    }
}

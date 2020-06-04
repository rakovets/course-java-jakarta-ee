package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManeger;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.sql.Connection;
import java.sql.SQLException;

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

        return null;
    }

    @Override
    public Review show(Review review) throws SQLException {
        return null;
    }
}

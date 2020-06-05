package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.sql.SQLException;

public interface ReviewDao <RE> extends Dao<Review>{
    public Review get (Integer id) throws SQLException;
}

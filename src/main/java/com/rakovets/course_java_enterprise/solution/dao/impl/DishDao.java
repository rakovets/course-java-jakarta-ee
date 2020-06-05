package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;

import java.sql.SQLException;

public interface DishDao <D> extends Dao<Dish> {
    public Dish get (Integer id) throws SQLException;
}

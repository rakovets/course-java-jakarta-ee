package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Restauran;

import java.sql.SQLException;
import java.util.List;

public interface RestaurantDao <R> extends Dao<Restauran> {
    List<Restauran> findall () throws SQLException;
}

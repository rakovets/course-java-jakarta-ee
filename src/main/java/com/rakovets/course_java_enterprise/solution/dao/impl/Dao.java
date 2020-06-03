package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import java.sql.SQLException;

public interface Dao<T> {
    T add(T t) throws SQLException;

    T show(T t) throws SQLException;
}

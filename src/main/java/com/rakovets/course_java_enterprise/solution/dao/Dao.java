package com.rakovets.course_java_enterprise.solution.dao;

import java.sql.SQLException;

public interface Dao<T> {
    T save(T t) throws SQLException;

    T find(long id) throws SQLException;

    T update(T t) throws SQLException;

    boolean delete(T t) throws SQLException;
}

package main.java.com.rakovets.course_java_enterprise.solution.dao;

import java.sql.SQLException;

public interface Dao<T> {
	T save(T t) throws SQLException;
}
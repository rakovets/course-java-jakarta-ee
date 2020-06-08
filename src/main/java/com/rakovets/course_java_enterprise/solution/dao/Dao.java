package main.java.com.rakovets.course_java_enterprise.solution.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	T save(T t) throws SQLException;

	List<T> findAll();
}
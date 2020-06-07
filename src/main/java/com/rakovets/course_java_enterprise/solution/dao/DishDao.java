package main.java.com.rakovets.course_java_enterprise.solution.dao;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;

public interface DishDao<D> extends Dao<Dish>{
	boolean verifyExistenceDishID(int id);
}

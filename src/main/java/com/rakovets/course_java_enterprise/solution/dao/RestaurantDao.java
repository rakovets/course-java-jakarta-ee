package main.java.com.rakovets.course_java_enterprise.solution.dao;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;

public interface RestaurantDao<R> extends Dao<Restaurant>{
	Dish saveDish(Dish dish, int restaurant_id);

	boolean verifyExistenceRestaurantID(int id);
}

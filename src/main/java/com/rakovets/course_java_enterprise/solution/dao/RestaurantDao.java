package main.java.com.rakovets.course_java_enterprise.solution.dao;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;

public interface RestaurantDao<R> extends Dao<Restaurant>{
	boolean addDishToRestaurant(int restaurantID, int dishID);

	Restaurant showRestaurantByID(int restaurantID);

	boolean verifyExistenceRestaurantID(int id);
}
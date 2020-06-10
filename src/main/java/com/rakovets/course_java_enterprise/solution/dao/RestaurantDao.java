package main.java.com.rakovets.course_java_enterprise.solution.dao;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.sql.SQLException;

public interface RestaurantDao extends Dao<Restaurant> {
    Dish saveDishToRestaurant(Dish dish, long restaurantId);

    Review saveReviewToRestaurant(Review review, long restaurantId);

    Restaurant getRestaurantById(long restaurantId);
}

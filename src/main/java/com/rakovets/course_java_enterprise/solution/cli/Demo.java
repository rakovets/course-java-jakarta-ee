package main.java.com.rakovets.course_java_enterprise.solution.cli;

import main.java.com.rakovets.course_java_enterprise.solution.dao.Impl.RestaurantDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.dao.Impl.ReviewDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

public class Demo {
    public static void main(String[] args) {

        RestaurantDaoImpl restaurantDao = RestaurantDaoImpl.getInstance();
//        Restaurant savedRestaurant = restaurantDao.save(new Restaurant("Big Pizza"));
//        System.out.println(savedRestaurant);

//        ReviewDaoImpl reviewDao = ReviewDaoImpl.getInstance();
//        Review savedReview = reviewDao.save(new Review("Great restaurant for lover of french meal", 11));
//        System.out.println(savedReview);

//        restaurantDao.saveDishToRestaurant("Sunny", new Dish("Lazania"));

        Dish dish = restaurantDao.saveDishToRestaurant(new Dish("Provance"), 1);
        System.out.println(dish.toString());
    }

    public void menu() {
        System.out.println("\nChoose action:\n1. save restaurant in DB\n2. save review in DB\n" +
                "3. save dish for definite restaurant\n4. save review for definite restaurant\n" +
                "5. get restaurant by ID\n");
    }
}

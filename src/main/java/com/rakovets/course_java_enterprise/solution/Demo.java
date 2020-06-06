package main.java.com.rakovets.course_java_enterprise.solution;

import main.java.com.rakovets.course_java_enterprise.solution.dao.RestaurantDao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        RestaurantDao restaurantDao = new RestaurantDao();
        try {
            Restaurant savedRestaurant = restaurantDao.save(new Restaurant("God is one of us"));
            System.out.println(savedRestaurant);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

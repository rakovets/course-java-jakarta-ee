package main.java.com.rakovets.course_java_enterprise.solution.cli;

import main.java.com.rakovets.course_java_enterprise.solution.dao.Impl.RestaurantDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.dao.Impl.ReviewDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Boolean menuWork = true;
        Scanner scanner = new Scanner(System.in);
        RestaurantDaoImpl restaurantDao = RestaurantDaoImpl.getInstance();
        ReviewDaoImpl reviewDao = ReviewDaoImpl.getInstance();
        menu();

        while (menuWork) {

            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                System.out.println("Enter title of restaurant:\n");
                String titleOfRestaurant = scanner.nextLine();
                Restaurant savedRestaurant = restaurantDao.save(new Restaurant(titleOfRestaurant));
                System.out.println("Restaurant saved in DB:\n" + savedRestaurant);
                menu();
            } else if (answer.equals("2")) {
                System.out.println("Enter content of review:\n");
                String contentOfReview = scanner.nextLine();
                System.out.println("Enter id of restaurant:\n");
                long idOfRestaurant = scanner.nextLong();
                Review review = reviewDao.save(new Review(contentOfReview, idOfRestaurant));
                System.out.println("Review saved in DB:\n" + review.toString());
                menu();
            } else if (answer.equals("3")) {
                System.out.println("Enter title of dish:\n");
                String titleOfDish = scanner.nextLine();
                System.out.println("Enter id of restaurant:\n");
                long idOfRestaurant = scanner.nextLong();
                Dish dish = restaurantDao.saveDishToRestaurant(new Dish(titleOfDish), idOfRestaurant);
                System.out.println("Dish saved in DB:\n" + dish.toString());
                menu();
            }
        }
    }

    public static void menu() {
        System.out.println("\nEnter number of action:\n1. save restaurant in DB\n2. save review in DB\n" +
                "3. save dish for definite restaurant\n4. save review for definite restaurant\n" +
                "5. get restaurant by ID\n6. EXIT\n");
    }
}

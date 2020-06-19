package com.rakovets.course_java_enterprise.solution.cli;

import com.rakovets.course_java_enterprise.solution.dao.Impl.RestaurantDaoImpl;
import com.rakovets.course_java_enterprise.solution.dao.Impl.ReviewDaoImpl;
import com.rakovets.course_java_enterprise.solution.entity.Dish;
import com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import com.rakovets.course_java_enterprise.solution.entity.Review;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Boolean menuWork = true;
        Scanner scanner = new Scanner(System.in);
        RestaurantDaoImpl restaurantDao = RestaurantDaoImpl.getInstance();
        ReviewDaoImpl reviewDao = ReviewDaoImpl.getInstance();
        printMenu();

        while (menuWork) {

            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                System.out.println("Enter title of restaurant:\n");
                String titleOfRestaurant = scanner.nextLine();
                Restaurant savedRestaurant = restaurantDao.save(new Restaurant(titleOfRestaurant));
                System.out.println("Restaurant saved in DB:\n" + savedRestaurant);
                printMenu();
            } else if (answer.equals("2")) {
                System.out.println("Enter content of review:\n");
                String contentOfReview = scanner.nextLine();
                System.out.println("Enter id of restaurant:\n");
                long idOfRestaurant = scanner.nextLong();
                Review review = reviewDao.save(new Review(contentOfReview, idOfRestaurant));
                System.out.println("Review saved in DB:\n" + review.toString());
                printMenu();
            } else if (answer.equals("3")) {
                System.out.println("Enter title of dish:\n");
                String titleOfDish = scanner.nextLine();
                System.out.println("Enter id of restaurant:\n");
                long idOfRestaurant = scanner.nextLong();
                Dish dish = restaurantDao.saveDishToRestaurant(new Dish(titleOfDish), idOfRestaurant);
                System.out.println("Dish saved in DB:\n" + dish.toString());
                printMenu();
            } else if (answer.equals("4")) {
                System.out.println("Enter content of review:\n");
                String contentOfReview = scanner.nextLine();
                System.out.println("Enter id of restaurant:\n");
                long idOfRestaurant = scanner.nextLong();
                Review review = restaurantDao.
                        saveReviewToRestaurant(new Review(contentOfReview, idOfRestaurant), idOfRestaurant);
                System.out.println("Review saved in DB:\n" + review.toString());
                printMenu();
            } else if (answer.equals("5")) {
                System.out.println("Enter ID of restaurant");
                long restaurantId = scanner.nextLong();
                Restaurant restaurant = restaurantDao.getRestaurantById(restaurantId);
                System.out.println("Restaurant: \n");
                System.out.println(restaurant);
                printMenu();
            } else if (answer.equals("6")) {
                break;
            } else {
                System.out.println("Choose action that exist!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nEnter number of action:\n1. save restaurant in DB\n2. save review in DB\n" +
                "3. save dish for definite restaurant\n4. save review for definite restaurant\n" +
                "5. get restaurant by ID\n6. EXIT\n");
    }
}

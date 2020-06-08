package main.java.com.rakovets.course_java_enterprise.solution.view;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.util.List;

public class Print {
	public void actionOptionsUI() {
		System.out.print("\nAction options:\n1. Create new restaurant\n2. Add review to restaurant\n" +
				"3. Create new dish\n4. Add dish to restaurant\n5. Show restaurant with dishes and reviews by ID\n" +
				"6. Show all restaurants\n7. Show all dishes\n8. Show all reviews\n9. Exit\n\nEnter number: > ");
	}

	public void enterNameRestaurant() {
		System.out.print("\nEnter name restaurant: > ");
	}

	public void enterNameDish() {
		System.out.print("\nEnter name dish: > ");
	}

	public void enterContentReview() {
		System.out.print("\nEnter content review: > ");
	}

	public void enterIdRestaurant() {
		System.out.print("\nEnter ID restaurant: > ");
	}

	public void enterIdDish() {
		System.out.print("\nEnter ID dish: > ");
	}

	public void showRestaurant(Restaurant restaurant) {
		System.out.println(restaurant);
	}

	public void showReview(Review review) {
		System.out.println(review);
	}

	public void showDish(Dish dish) {
		System.out.println(dish);
	}

	public void listRestaurants(List<Restaurant> listRestaurants) {
		System.out.println("All restaurants: ");
		listRestaurants.forEach(unit -> System.out.println(String.format("id = %d, name = '%s'",
				unit.getId(), unit.getName())));
	}

	public void listDishes(List<Dish> listDishes) {
		System.out.println("All dishes: ");
		listDishes.forEach(unit -> System.out.println(String.format("id = %d, name = '%s'",
				unit.getId(), unit.getName())));
	}

	public void listReviews(List<Review> listReviews) {
		System.out.println("All Reviews: ");
		listReviews.forEach(unit -> System.out.println(String.format("id = %d, name = '%s', restaurant ID = %d",
				unit.getId(), unit.getContent(), unit.getRestaurantID())));
	}
}
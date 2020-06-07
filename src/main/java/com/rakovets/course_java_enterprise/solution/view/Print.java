package main.java.com.rakovets.course_java_enterprise.solution.view;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

public class Print {
	public void actionOptionsUI() {
		System.out.print("\nAction options:\n1. Create new restaurant\n2. Add review to restaurant\n" +
				"3. Create new dish\n4. Add dish to restaurant\n5. Show restaurant by ID\n6. Exit\n\n" +
				"Enter number: > ");
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
}
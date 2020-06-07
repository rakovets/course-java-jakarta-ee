package main.java.com.rakovets.course_java_enterprise.solution.view;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

public class Print {
	public void actionOptionsUI() {
		System.out.print("\nAction options:\n1. Add restaurant\n2. Add review\n3. Exit\n\nEnter number: > ");
	}

	public void enterNameRestaurant() {
		System.out.print("\nEnter name restaurant: > ");
	}

	public void enterContentReview() {
		System.out.print("\nEnter content review: > ");
	}

	public void enterIdRestaurant() {
		System.out.print("\nEnter ID restaurant: > ");
	}

	public void restaurant(Restaurant restaurant) {
		System.out.println(restaurant);
	}

	public void review(Review review) {
		System.out.println(review);
	}
}
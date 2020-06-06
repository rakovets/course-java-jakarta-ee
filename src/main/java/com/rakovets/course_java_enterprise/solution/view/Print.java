package main.java.com.rakovets.course_java_enterprise.solution.view;

import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;

public class Print {
	public void actionOptionsUI() {
		System.out.print("\nAction options:\n1. Add restaurant\n2. Exit\n\nEnter number: > ");
	}

	public void enterNameRestaurant() {
		System.out.print("\nEnter name restaurant: > ");
	}

	public void restaurant(Restaurant restaurant) {
		System.out.println(restaurant);
	}
}
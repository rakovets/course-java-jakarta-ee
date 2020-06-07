package main.java.com.rakovets.course_java_enterprise.solution.conrollers;

import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.DishDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.RestaurantDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.ReviewDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;
import main.java.com.rakovets.course_java_enterprise.solution.instanceObject.InstanceObject;
import main.java.com.rakovets.course_java_enterprise.solution.view.Print;

import java.util.Scanner;

public class Controller {
	private Scanner scannerInt = new Scanner(System.in);
	private Scanner scannerLine = new Scanner(System.in);

	public void runController() {
		RestaurantDaoImpl restaurantDaoImpl;
		ReviewDaoImpl reviewDaoImpl;
		DishDaoImpl dishDaoImpl;
		Print print;
		boolean runMain = true;
		while (runMain) {
			restaurantDaoImpl = InstanceObject.getInstanceRestaurantDao();
			reviewDaoImpl = InstanceObject.getInstanceReviewDao();
			dishDaoImpl = InstanceObject.getInstanceDishDao();
			print = InstanceObject.getInstancePrint();

			print.actionOptionsUI();
			int command = scannerInt.nextInt();
			switch (command) {
				case 1:
					print.enterNameRestaurant();
					Restaurant savedRestaurant = restaurantDaoImpl.save(new Restaurant(scannerLine.nextLine()));
					print.showRestaurant(savedRestaurant);
					break;
				case 2:
					print.enterIdRestaurant();
					int restaurantIdForAddReview = scannerInt.nextInt();
					if (!restaurantDaoImpl.verifyExistenceRestaurantID(restaurantIdForAddReview)) {
						break;
					}
					print.enterContentReview();
					String content = scannerLine.nextLine();
					Review review = reviewDaoImpl.save(new Review(content, restaurantIdForAddReview));
					print.showReview(review);
					break;
				case 3:
					print.enterNameDish();
					Dish dish = dishDaoImpl.save(new Dish(scannerLine.nextLine()));
					print.showDish(dish);
					break;
				case 4:
					print.enterIdRestaurant();
					int restaurantIdForAddDish = scannerInt.nextInt();
					if (!restaurantDaoImpl.verifyExistenceRestaurantID(restaurantIdForAddDish)) {
						break;
					}
					print.enterIdDish();
					int dishID = scannerInt.nextInt();
					if (!dishDaoImpl.verifyExistenceDishID(dishID)) {
						break;
					}
					boolean resultAdd = restaurantDaoImpl.addDishToRestaurant(restaurantIdForAddDish, dishID);
					System.out.println(resultAdd);
					break;
				case 5:
					print.enterIdRestaurant();
					int restaurantId = scannerInt.nextInt();
					if (!restaurantDaoImpl.verifyExistenceRestaurantID(restaurantId)) {
						break;
					}
					Restaurant restaurant = restaurantDaoImpl.showRestaurantByID(restaurantId);
					print.showRestaurant(restaurant);
					break;
				case 6:
					runMain = false;
					break;
				default:
					System.out.println("COMMAND NUMBER NOT EXIST");
			}
		}
	}
}
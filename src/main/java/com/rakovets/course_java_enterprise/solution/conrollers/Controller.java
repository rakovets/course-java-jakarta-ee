package main.java.com.rakovets.course_java_enterprise.solution.conrollers;

import main.java.com.rakovets.course_java_enterprise.solution.dao.inst.RestaurantDaoInst;
import main.java.com.rakovets.course_java_enterprise.solution.dao.inst.ReviewDaoInst;
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
		RestaurantDaoInst restaurantDao;
		ReviewDaoInst reviewDao;
		Print print;
		boolean runMain = true;
		while (runMain) {
			print = InstanceObject.getInstancePrint();
			print.actionOptionsUI();
			int command = scannerInt.nextInt();
			switch (command) {
				case 1:
					restaurantDao = InstanceObject.getInstanceRestaurantDao();
					print.enterNameRestaurant();
					Restaurant savedRestaurant = restaurantDao.save(new Restaurant(scannerLine.nextLine()));
					print.showRestaurant(savedRestaurant);
					break;
				case 2:
					reviewDao = InstanceObject.getInstanceReviewDao();
					restaurantDao = InstanceObject.getInstanceRestaurantDao();
					print.enterIdRestaurant();
					int restaurantIdForAddReview = scannerInt.nextInt();
					if (!restaurantDao.verifyExistenceRestaurantID(restaurantIdForAddReview)) {
						break;
					}
					print.enterContentReview();
					String content = scannerLine.nextLine();
					Review review = reviewDao.save(new Review(content, restaurantIdForAddReview));
					print.showReview(review);
					break;
				case 3:
					restaurantDao = InstanceObject.getInstanceRestaurantDao();
					print.enterIdRestaurant();
					int restaurantIdForAddDish = scannerInt.nextInt();
					if (!restaurantDao.verifyExistenceRestaurantID(restaurantIdForAddDish)) {
						break;
					}
					print.enterNameDish();
					String nameDish = scannerLine.nextLine();
					Dish dish = restaurantDao.saveDish(new Dish(nameDish), restaurantIdForAddDish);
					print.showDish(dish);
					break;
				case 4:
					runMain = false;
					break;
				default:
					System.out.println("COMMAND NUMBER NOT EXIST");
			}
		}
	}
}
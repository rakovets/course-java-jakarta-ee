package main.java.com.rakovets.course_java_enterprise.solution.conrollers;

import main.java.com.rakovets.course_java_enterprise.solution.dao.inst.RestaurantDaoInst;
import main.java.com.rakovets.course_java_enterprise.solution.dao.inst.ReviewDaoInst;
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
					print.restaurant(savedRestaurant);
					break;
				case 2:
					reviewDao = InstanceObject.getInstanceReviewDao();
					restaurantDao = InstanceObject.getInstanceRestaurantDao();
					print.enterIdRestaurant();
					int restaurantID = scannerInt.nextInt();
					if (!reviewDao.verificationID(restaurantID)) {
						break;
					}
					print.enterContentReview();
					String content = scannerLine.nextLine();
					Review review = reviewDao.save(new Review(content, restaurantID));
					print.review(review);
					break;
				case 3:
					runMain = false;
					break;
				default:
					System.out.println("COMMAND NUMBER NOT EXIST");
			}
		}
	}
}
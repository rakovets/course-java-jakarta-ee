package main.java.com.rakovets.course_java_enterprise.solution.conrollers;

import main.java.com.rakovets.course_java_enterprise.solution.dao.RestaurantDao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.instanceObject.InstanceObject;
import main.java.com.rakovets.course_java_enterprise.solution.view.Print;

import java.util.Scanner;

public class Controller {
	private Scanner scannerInt = new Scanner(System.in);
	private Scanner scannerLine = new Scanner(System.in);

	public void runController() {
		RestaurantDao restaurantDao;
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
					runMain = false;
					break;
				default:
					System.out.println("COMMAND NUMBER NOT EXIST");
			}
		}
	}
}
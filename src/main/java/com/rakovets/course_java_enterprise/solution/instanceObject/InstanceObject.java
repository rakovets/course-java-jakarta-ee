package main.java.com.rakovets.course_java_enterprise.solution.instanceObject;

import main.java.com.rakovets.course_java_enterprise.solution.dao.RestaurantDao;
import main.java.com.rakovets.course_java_enterprise.solution.view.Print;

public class InstanceObject {
	private static final Object LOCK = new Object();
	private static RestaurantDao restaurantDao = null;
	private static Print print = null;

	public static RestaurantDao getInstanceRestaurantDao() {
		if (restaurantDao == null) {
			synchronized (LOCK) {
				if (restaurantDao == null) {
					restaurantDao = new RestaurantDao();
				}
			}
		}
		return restaurantDao;
	}

	public static Print getInstancePrint() {
		if (print == null) {
			synchronized (LOCK) {
				if (print == null) {
					print = new Print();
				}
			}
		}
		return print;
	}
}
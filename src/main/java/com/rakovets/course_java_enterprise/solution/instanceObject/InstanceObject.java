package main.java.com.rakovets.course_java_enterprise.solution.instanceObject;

import main.java.com.rakovets.course_java_enterprise.solution.dao.inst.RestaurantDaoInst;
import main.java.com.rakovets.course_java_enterprise.solution.dao.inst.ReviewDaoInst;
import main.java.com.rakovets.course_java_enterprise.solution.view.Print;

public class InstanceObject {
	private static final Object LOCK = new Object();
	private static RestaurantDaoInst restaurantDao = null;
	private static ReviewDaoInst reviewDao = null;
	private static Print print = null;

	public static RestaurantDaoInst getInstanceRestaurantDao() {
		if (restaurantDao == null) {
			synchronized (LOCK) {
				if (restaurantDao == null) {
					restaurantDao = new RestaurantDaoInst();
				}
			}
		}
		return restaurantDao;
	}

	public static ReviewDaoInst getInstanceReviewDao() {
		if (reviewDao == null) {
			synchronized (LOCK) {
				if (reviewDao == null) {
					reviewDao = new ReviewDaoInst();
				}
			}
		}
		return reviewDao;
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
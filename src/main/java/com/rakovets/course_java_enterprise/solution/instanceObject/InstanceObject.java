package main.java.com.rakovets.course_java_enterprise.solution.instanceObject;

import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.DishDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.RestaurantDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.ReviewDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.view.Print;

import java.util.ArrayList;
import java.util.List;

public class InstanceObject {
	private static final Object LOCK = new Object();
	private static RestaurantDaoImpl restaurantDao = null;
	private static ReviewDaoImpl reviewDao = null;
	private static DishDaoImpl dishDao = null;
	private static List listDishes = null;
	private static List listReview = null;
	private static List listRestaurant = null;
	private static Print print = null;

	public static RestaurantDaoImpl getInstanceRestaurantDao() {
		if (restaurantDao == null) {
			synchronized (LOCK) {
				if (restaurantDao == null) {
					restaurantDao = new RestaurantDaoImpl();
				}
			}
		}
		return restaurantDao;
	}

	public static ReviewDaoImpl getInstanceReviewDao() {
		if (reviewDao == null) {
			synchronized (LOCK) {
				if (reviewDao == null) {
					reviewDao = new ReviewDaoImpl();
				}
			}
		}
		return reviewDao;
	}

	public static DishDaoImpl getInstanceDishDao() {
		if (dishDao == null) {
			synchronized (LOCK) {
				if (dishDao == null) {
					dishDao = new DishDaoImpl();
				}
			}
		}
		return dishDao;
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

	public static List getInstanceListDishes() {
		if (listDishes == null) {
			synchronized (LOCK) {
				if (listDishes == null) {
					listDishes = new ArrayList();
				}
			}
		}
		return listDishes;
	}

	public static List getInstanceListReview() {
		if (listReview == null) {
			synchronized (LOCK) {
				if (listReview == null) {
					listReview = new ArrayList();
				}
			}
		}
		return listReview;
	}

	public static List getInstanceListRestaurant() {
		if (listRestaurant == null) {
			synchronized (LOCK) {
				if (listRestaurant == null) {
					listRestaurant = new ArrayList();
				}
			}
		}
		return listRestaurant;
	}
}
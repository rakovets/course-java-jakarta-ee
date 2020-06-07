package main.java.com.rakovets.course_java_enterprise.solution.entity;

import java.util.List;

public class Restaurant {
	private int id;
	private String name;
	private List<Dish> listDish;
	private List<Review> listReview;

	public Restaurant(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dish> getListDish() {
		return listDish;
	}

	public void setListDish(List<Dish> listDish) {
		this.listDish = listDish;
	}

	public List<Review> getListReview() {
		return listReview;
	}

	public void setListReview(List<Review> listReview) {
		this.listReview = listReview;
	}

	@Override
	public String toString() {
		return String.format("Restaurant { id=%-3d, name='%s' }", id, name);
	}
}
package main.java.com.rakovets.course_java_enterprise.solution.entity;

import java.util.List;

public class Restaurant {
	private int id;
	private String name;
	private List<Dish> listDish;

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

	@Override
	public String toString() {
		return String.format("Restaurant { id=%-3d, name='%s' }", id, name);
	}
}
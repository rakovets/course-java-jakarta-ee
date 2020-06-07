package main.java.com.rakovets.course_java_enterprise.solution.entity;

public class Review {
	private int id;
	private String content;
	private int restaurantID;

	public Review(String content, int restaurantID) {
		this.content = content;
		this.restaurantID = restaurantID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	@Override
	public String toString() {
		return String.format("Review { id = %-3d, content = '%s', restaurant_id = %d }", id, content, restaurantID);
	}
}
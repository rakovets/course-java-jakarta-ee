package main.java.com.rakovets.course_java_enterprise.solution.entity;

public class Review {
    private long id;
    private String content;
    private Restaurant restaurant;

    public Review(String content, Restaurant restaurant) {
        this.content = content;
        this.restaurant = restaurant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", restaurant=" + restaurant +
                '}';
    }
}

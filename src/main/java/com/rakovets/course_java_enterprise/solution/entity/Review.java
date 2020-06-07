package main.java.com.rakovets.course_java_enterprise.solution.entity;

public class Review {
    private long id;
    private String content;
    private long restaurant;

    public Review(String content, long restaurant) {
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

    public long getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(long restaurant) {
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

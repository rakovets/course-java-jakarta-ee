package main.java.com.rakovets.course_java_enterprise.solution.entity;

public class Restaurant {
    private long id;
    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

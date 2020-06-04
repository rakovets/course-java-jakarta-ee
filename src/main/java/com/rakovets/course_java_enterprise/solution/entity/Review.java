package main.java.com.rakovets.course_java_enterprise.solution.entity;

public class Review {
    private long id;
    private String content;
    private Restauran restauran;

    public Review(String content) {
        this.id = id;
        this.content = content;
        this.restauran = restauran;
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

    public Restauran getRestauran() {
        return restauran;
    }

    public void setRestauran(Restauran restauran) {
        this.restauran = restauran;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", restauran=" + restauran +
                '}';
    }
}

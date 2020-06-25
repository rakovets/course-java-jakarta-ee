package com.rakovets.course_java_enterprise.solution.el.dto;

public class ArtistDto {
    private long id;
    private String name;
    private boolean russian;

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

    public boolean isRussian() {
        return russian;
    }

    public void setRussian(boolean russian) {
        this.russian = russian;
    }
}

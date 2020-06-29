package com.rakovets.course_java_enterprise.solution.entity;

import java.util.ArrayList;

public class ArtistDto {
    private int id;
    private String name;
    private boolean russian;
    private ArrayList artistsList = new ArrayList();

    public ArtistDto(String name, boolean russian) {
        this.name = name;
        this.russian = russian;
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

    public boolean isRussian() {
        return russian;
    }

    public void setRussian(boolean russian) {
        this.russian = russian;
    }

    public ArrayList getArtistsList() {
        return artistsList;
    }

    public void setArtistsList(ArrayList artistsList) {
        this.artistsList = artistsList;
    }

    @Override
    public String toString() {
        return String.format("Id: %d<br>Имя исполнителя: %s<br>Русская музыка: %b", id, name, russian);
    }
}
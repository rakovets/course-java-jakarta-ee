package com.rakovets.course_java_enterprise.solution.entity;

public class User {
    private String login;
    private String password;

    public User(String name, String password) {
        this.login = name;
        this.password = password;
    }

    public String getName() {
        return login;
    }

    public void setName(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


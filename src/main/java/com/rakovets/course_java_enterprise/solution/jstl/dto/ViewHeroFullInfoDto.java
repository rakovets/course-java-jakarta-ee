package com.rakovets.course_java_enterprise.solution.jstl.dto;


public class ViewHeroFullInfoDto {
    private String name;
    private String identity;
    private String gender;
    private int age;
    private String abilityName;

    public ViewHeroFullInfoDto(String name, String identity, String gender, int age, String abilityName) {
        this.name = name;
        this.identity = identity;
        this.gender = gender;
        this.age = age;
        this.abilityName = abilityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }
}

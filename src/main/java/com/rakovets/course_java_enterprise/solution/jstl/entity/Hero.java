package com.rakovets.course_java_enterprise.solution.jstl.entity;


public class Hero extends BaseEntity {
    private String name;
    private String identity;
    private int age;
    private Gender gender = Gender.MALE;
    private Ability ability;

    public Hero(String name, String identity, int age, Gender gender) {
        this.name = name;
        this.identity = identity;
        this.age = age;
        this.gender = gender;
    }


    public Hero(long id, String name, String identity, int age, Gender gender, Ability ability) {
        super(id);
        this.name = name;
        this.identity = identity;
        this.age = age;
        this.gender = gender;
        this.ability = ability;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}

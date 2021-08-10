package by.rakovets.course.java.jakarta_ee.jstl.dto;


import by.rakovets.course.java.jakarta_ee.jstl.entity.Gender;

public class CreateNewHeroDto {
    private String name;
    private String identity;
    private int age;
    private Gender gender;
    private long abilityId;

    public CreateNewHeroDto(String name, String identity, int age, Gender gender, long abilityId) {
        this.name = name;
        this.identity = identity;
        this.age = age;
        this.gender = gender;
        this.abilityId = abilityId;
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

    public long getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(long abilityId) {
        this.abilityId = abilityId;
    }
}

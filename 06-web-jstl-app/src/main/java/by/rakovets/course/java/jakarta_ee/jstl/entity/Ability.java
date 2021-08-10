package by.rakovets.course.java.jakarta_ee.jstl.entity;


public class Ability extends BaseEntity {
    private String name;

    public Ability(long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ability ability = (Ability) o;

        return name.equals(ability.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

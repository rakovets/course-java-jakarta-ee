package by.rakovets.course.java.jakarta_ee.el.dto;


public class ArtistDto {
    private long id;
    private String name;
    private boolean classical;

    public ArtistDto(long id, String name, boolean classical) {
        this.id = id;
        this.name = name;
        this.classical = classical;
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

    public boolean isClassical() {
        return classical;
    }

    public void setClassical(boolean classical) {
        this.classical = classical;
    }
}

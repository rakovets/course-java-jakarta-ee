package by.rakovets.course.java.jakarta_ee.jstl.dto;


public class ViewHeroBasicInfoDto {
    private long id;
    private String name;

    public ViewHeroBasicInfoDto(long id, String name) {
        this.id = id;
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

package domain.user;

public class Companys {
    private String name;
    private String cvrNumb;

    public Companys(String name, String cvrNumb) {
        this.name = name;
        this.cvrNumb = cvrNumb;
    }

    public String getCvrNumb() {
        return cvrNumb;
    }

    public String getName() {
        return name;
    }

    public void setCvrNumb(String cvrNumb) {
        this.cvrNumb = cvrNumb;
    }

    public void setName(String name) {
        this.name = name;
    }
}
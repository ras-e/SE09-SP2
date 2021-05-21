package domain.user;

public class BusinessMan extends User {
    String business;

    public BusinessMan(String name, String username, String password, String email, String business) {
        super(name, username, password, email);
        this.business = business;
    }
}
package domain.user;

public class Admin extends User {


    public Admin(int id, String name, String username, String password, String email, String business, int type) {
        super(id, name, username, password, email, business, type);
    }
}
package domain.user;

public class Producer extends User {

    public String business;

    public Producer(String id, String name, String username, String password, String email, String business, int type) {
        super(id, name, username, password, email, business, type);
    }


    public void createProgram () {

    }

}
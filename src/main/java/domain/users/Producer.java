package domain.users;

public class Producer extends Account {

    public String business;

    public Producer (String email, String firstName, String lastName, String business) {
        super(email,firstName,lastName);
        this.business = business;
    }
    public void createProgram () {

    }

}
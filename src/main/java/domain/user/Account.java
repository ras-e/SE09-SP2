package domain.user;

public abstract class Account {
    public String email;
    public String firstName;
    public String lastName;
    public int id;

    public Account (String email, String firstName, String lastName, int id) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    }
    
}
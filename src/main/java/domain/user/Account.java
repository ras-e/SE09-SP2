package domain.user;

public class Account {
        public String email;
        public String firstName;
        public String lastName;
        public int id;
        public int type;

        public Account (String email, String firstName, String lastName, int id, int type) {
                this.email = email;
                this.firstName = firstName;
                this.lastName = lastName;
                this.id = id;
                this.type = type;
        }

}
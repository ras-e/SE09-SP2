package domain.user;

import java.util.UUID;

public abstract class Account {
        public String email;
        public String firstName;
        public String lastName;
        public UUID id;

        public Account (String email, String firstName, String lastName) {
                this.email = email;
                this.firstName = firstName;
                this.lastName = lastName;
                this.id = UUID.randomUUID();
        }

        public String getEmail() {
                return email;
        }

        public String getFirstName() {
                return firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public UUID getId() {
                return id;
        }

}
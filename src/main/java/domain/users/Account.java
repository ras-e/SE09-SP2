package domain.users;

import java.util.UUID;

public abstract class Account {
        private String email;
        private String firstName;
        private String lastName;
        private UUID id;

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
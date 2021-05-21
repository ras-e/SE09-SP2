package domain.user;

public class User {
        int id;
        String name;
        String username;
        String password;
        String email;
        String date;
        int type;


        public User( String name, String username, String password, String email) {
                this.name = name;
                this.username = username;
                this.password = password;
                this.email = email;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public int getType() {
                return type;
        }

        public void setType(int type) {
                this.type = type;
        }
}
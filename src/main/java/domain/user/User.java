package domain.user;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {
        private int id;
        private String name;
        private String username;
        private String password;
        private String email;
        private String date;
        private int type;
        private ObservableList<String> infList = FXCollections.observableArrayList();




        public User(String name, String username, String password, String email) {
                this.name = name;
                this.username = username;
                this.password = password;
                this.email = email;
                //Required fix
                type = 1;
                infList.addAll("Name: "+name,"Username: "+username,"password: "+password,"email: "+email);
        }

        public User(int id, String name, String username, String password, String email, String business, int type) {
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

        public ObservableList<String> returnUserInf(){
                return infList;
        }
}
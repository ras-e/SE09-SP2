package domain.Program;

import java.io.Serializable;

public class mvPerson implements Serializable {

    String Fname;
    String Lname;
    int mvPersonID;

    public mvPerson(String fName, String lName){
        this.Fname = fName;
        this.Lname = lName;
    }

    public mvPerson(String fname, String Lname, int mvPersonID) {
        this.Fname = fname;
        this.Lname = Lname;
        this.mvPersonID = mvPersonID;
    }

    public String getFname() {
        return this.Fname;
    }
    public String getname() {
        return Fname + Lname;
    }


    public int getID() {
        return mvPersonID;
    }

    public String toString(){
        return "First name: "+this.Fname +" Last name: "+this.Lname;
    }
}



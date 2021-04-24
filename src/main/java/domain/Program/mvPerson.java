package domain.Program;

public class mvPerson {

    String Fname;
    String Lname;
    int mvPersonID;

    public mvPerson(String fname, String Lname, int mvPersonID) {
        this.Fname = fname;
        this.Lname = Lname;
        this.mvPersonID = mvPersonID;
    }

    public String getname() {
        return Fname + Lname;
    }


    public int getID() {
        return mvPersonID;
    }
}

}

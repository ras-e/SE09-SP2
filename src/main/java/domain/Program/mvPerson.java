package domain.Program;

public class mvPerson {

    String Fname;
    String Lname;
    int mvPersonID;

    public mvPerson(String Fname){
        this.Fname = Fname;
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
        return "FName: "+this.Fname;
    }
}



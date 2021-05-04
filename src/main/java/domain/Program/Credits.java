package domain.Program;


public class Credits {


    String ProdRole;
    int CreditID;
    mvPerson person;

    public  Credits (){

    }

    public Credits(String prodRole, int creditID, mvPerson person) {
        this.CreditID = creditID;
        this.ProdRole = prodRole;
        this.person = person;
    }



}

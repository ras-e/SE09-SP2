package domain.Program;


public class Credits {


    tvProdRolle ProdRole;
    int CreditID;
    mvPerson person;

    public  Credits (){

    }

    public Credits(tvProdRolle prodRole, int creditID, mvPerson person) {
        this.CreditID = creditID;
        this.ProdRole = prodRole;
        this.person = person;
    }



}

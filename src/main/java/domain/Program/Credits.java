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

    public Credits(tvProdRolle prodRole, mvPerson person){
        this.ProdRole = prodRole;
        this.person = person;
    }

    public String toString(){
        return "creditID: "+CreditID +"\n"
                +"Prodrole: "+ProdRole+"\n"
                +"Person"+person;
    }

}

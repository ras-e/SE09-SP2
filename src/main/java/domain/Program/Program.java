package domain.Program;

import domain.Facade.ioFacade;

import java.util.ArrayList;

public class Program {

        int ProdID;
        ArrayList<Credits> credlist;
        String Name;
        String prodName;
        Enum Category;

        public Program(int prodID, ArrayList<Credits> credlist, String name, String prodName, Enum chategory) {
            ProdID = prodID;
            this.credlist = credlist;
            Name = name;
            this.prodName = prodName;
            this.Category = chategory;
        }

        public static void main(String args[]) {

            ioFacade objectio = new ioFacade();

            // actionhandler på "opretkreditering" knap
            ArrayList<Credits> credlist = new ArrayList<Credits>();
            //objectio.writeobjecttofile(new Credits(), "et eller andet krediteringsliste navn");

        }
}

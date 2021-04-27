package domain.Program;

import java.util.ArrayList;

public class Program {

        int ProdID;
        ArrayList<Credits> credlist;
        String Name;
        String prodName;
        Enum Category;

        public Program(String prodName){
            this.prodName = prodName;
        }

        public Program(int prodID, ArrayList<Credits> credlist, String name, String prodName, Enum chategory) {
            ProdID = prodID;
            this.credlist = credlist;
            Name = name;
            this.prodName = prodName;
            this.Category = chategory;
        }

        public String getProgram(){
            return this.prodName;
        }

//        public static void main(String args[]) {
//
//            ioFacade objectio = new ioFacade();
//
//            // actionhandler på "opretkreditering" knap
//            ArrayList<Credits> credlist = new ArrayList<Credits>();
//           // objectio.writeobjecttofile(new Credits(), "et eller andet krediteringsliste navn");
//        }

        @Override
    public String toString(){
            return "Program name: "+this.prodName;
        }
}

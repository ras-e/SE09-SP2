package domain;

import Facade.ioFacade;
import domain.Program.Credits;
import domain.Program.Program;
import domain.Program.mvPerson;
import domain.user.Account;

import java.util.ArrayList;

public class sysController {
   static ArrayList<mvPerson> mvPersons = new ArrayList<>();
   static ArrayList<Credits> credits;
   static ArrayList<Program> programs;
   static ArrayList<Account> accounts;


    public static ArrayList<mvPerson> getmvPersons(){
        return mvPersons;
    }

    public static mvPerson createmvPerson(String fName, String lName){
        mvPerson person = new mvPerson(fName,lName);
        mvPersons.add(person);

        ioFacade.writeObjectToFiles(person,"C:\\Users\\ander\\IdeaProjects\\SE09-SP2_ny\\src\\main\\resources\\files\\personBinaryFileList");
        return person;
    }

    //lav funktion der viser objecter i

}

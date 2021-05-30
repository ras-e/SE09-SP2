package domain;

import domain.Program.Credits;
import domain.Program.Program;
import domain.Program.mvPerson;
import domain.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class sysController {
   static ArrayList<mvPerson> mvPersons = new ArrayList<>();
   static ArrayList<Credits> credits;
   static ArrayList<Program> programs;
   static ArrayList<User> user;

   //user session - bestemmer vindue der åbnes. 0=ikkeRegistreret,1=logged ind, 2= producer, 3=admin. bør lave en enum.
   public static int userSessionType = 0;
   public static User session;


   //Blok af dårligt design:
   public static ObservableList<mvPerson> oPersonList = FXCollections.observableArrayList();
   public static ObservableList<Program> oProgramList = FXCollections.observableArrayList();
   public static ObservableList<Credits> oCreditList =FXCollections.observableArrayList();
   public static ObservableList<User> oUserList = FXCollections.observableArrayList();
   public static Program currentProgram = new Program("Empty production");




    public static ArrayList<mvPerson> getmvPersons(){
        return mvPersons;
    }

    public static mvPerson createmvPerson(String fName, String lName){
        mvPerson person = new mvPerson(fName,lName);
        mvPersons.add(person);
        oPersonList.add(person);



       // ioFacade.writeObjectToFiles(person,"C:\\Users\\ander\\IdeaProjects\\SE09-SP2_ny\\src\\main\\resources\\files\\personBinaryFileList");

        return person;
    }

}

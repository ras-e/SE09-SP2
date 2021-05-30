package org.presentation;

import domain.Program.Credits;
import domain.Program.Program;
import domain.user.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Date;
import java.util.Objects;

import static domain.sysController.oProgramList;

public class adminController {

    @FXML
    public Button btnAddPro;
    @FXML
    private ChoiceBox kategorich2;
    @FXML
    private TextField namefield;
    @FXML
    private TextField participantsfield;
    @FXML
    private TextField datefield;
    @FXML
    private TextField countrytf;
    @FXML
    private Button searchbtn;
    @FXML
    private TableView<Program> programTable;

    @FXML
    private TableView<Credits> table;
    @FXML
    private TableColumn<Credits,String> namecol;
    @FXML
    private TableColumn<Credits,String> tvrolecol;
    @FXML
    private TableColumn<Credits,String> emailcol;
    @FXML
    private TableColumn<Credits, Date> datecol;


    //Accoutn management tab - Loading the add/del/edit scenes when button pressed
    @FXML
    public TextField compName;
    @FXML
    public TextField cvrNumb;
    @FXML
    public Button btnAddComp;



    //Program management tab
    public void loadAddProgram(MouseEvent mouseEvent){loadWindow("addProgram.fxml","Add new program");}
    public void loadEditProgram(MouseEvent mouseEvent){loadWindow("editProgram.fxml","Edit program");}
    public void loadDeleteProgram(MouseEvent mouseEvent){loadWindow("delProgram.fxml","Delete program");}

    //Account management tab
    public void loadAddMemberUI(MouseEvent mouseEvent) {
        loadWindow("addAcc.fxml", "Add New Acc");
    }
    public void loadDeleteMemberUI(MouseEvent mouseEvent) {
        loadWindow("delMember.fxml","Delete Member");
    }
    public void loadEditMemberUI(MouseEvent mouseEvent) {
        loadWindow("editMember.fxml","Edit Member");
    }

    //Production company tab
    @FXML
    private void handleAddComp (ActionEvent event) {
    String name = compName.getText();
    String cvr = cvrNumb.getText();
        UserManager.addCompanys(name, cvr);
    }

    @FXML
    private void searchprogramname(ActionEvent action){}

    //Method used to load new windows (here functions; add,del,edit windows)
   public void loadWindow(String path, String title)
    {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void choiceboxadmin () {
        ObservableList<String> navnPåString = FXCollections.observableArrayList();
        for (Program k : oProgramList) {
            System.out.println(k.getProdName());
            navnPåString.add(k.getProdName());
        }
        kategorich2.setItems(navnPåString);
    }

    public void visProgram(){
        loadWindow("producerUI.FXML","Producer page");
    }

//    @FXML
//    private void searchprogramname (ActionEvent event) {
//        Object source = event.getSource();
//        if (source.equals(searchbtn)) {
//            String name = namefield.getText();
//            AdminFacade.getcreditslist(name);
//
//            ObservableList<Credits> data = AdminFacade.getcreditslist(name);
//            table.setItems(data);
//        }
//    }
}
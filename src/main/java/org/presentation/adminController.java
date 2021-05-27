package org.presentation;

import animatefx.animation.ZoomIn;
import domain.Facade.AdminFacade;
import domain.Facade.ProducerFacade;
import domain.Program.Category;
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
import org.presentation.Presentationcontroller;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Objects;


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

    private TableView<Credits> table;
    @FXML
    private TableColumn<Credits,String> namecol;
    @FXML
    private TableColumn<Credits,String> tvrolecol;
    @FXML
    private TableColumn<Credits,String> emailcol;
    @FXML
    private TableColumn<Credits, Date> datecol;

    Presentationcontroller presentationcontroller;


    //Loading the add/del/edit scenes when button pressed
    @FXML
    public TextField compName;
    @FXML
    public TextField cvrNumb;
    @FXML
    public Button btnAddComp;

    //Loading the add/del/edit scenes when button pressed
    public void loadAddMemberUI(MouseEvent mouseEvent) {
        loadWindow("addAcc.fxml", "Add New Acc");
    }
    public void loadDeleteMemberUI(MouseEvent mouseEvent) {
        loadWindow("delMember.fxml","Delete Member");
    }
    public void loadEditMemberUI(MouseEvent mouseEvent) {
        loadWindow("editMember.fxml","Edit Member");
    }

    @FXML
    private void handleAddComp (ActionEvent event) {
        String name = compName.getText();
        String cvr = cvrNumb.getText();
        UserManager.addCompanys(name, cvr);
    }

    //Method used to load new windows (here functions; add,del,edit windows)
    void loadWindow(String path, String title)
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
    private void handleButtonAction (ActionEvent event) {
        if (event.getSource().equals(btnAddPro)) {
            presentationcontroller.changewindow("addProgram.fxml", "addprogram");
        }
    }

    //    --------------------------------------------------------------------------------------------------------------------
//        adminaddprogram

    @FXML
    private void choiceboxadmin () {
        ObservableList<String> navnPåString = FXCollections.observableArrayList();
        for (Category k : Category.values()) {
            navnPåString.add(k.toString());
        }
        kategorich2.setItems(navnPåString);
    }
    @FXML
    private void searchprogramname (ActionEvent event) {
        Object source = event.getSource();
        if (source.equals(searchbtn)) {
            String name = namefield.getText();
            AdminFacade.getcreditslist(name);

            ObservableList<Credits> data = AdminFacade.getcreditslist(name);
            table.setItems(data);
        }
    }

    public void initialize(URL url) {




    }

}
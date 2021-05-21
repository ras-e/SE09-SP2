package org.presentation;

import Persistence.PersistenceHandler;
import domain.Facade.LoginFacade;
import domain.Program.Category;
import domain.Program.Program;
import domain.user.User;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import static domain.Program.Category.gyser;

public class addProgramController {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button saveButton;
    @FXML
    private TextField nametf;
    @FXML
    private TextField countrytf;
    @FXML
    private TextField datetf;
    @FXML
    private ChoiceBox kategorich;


    //Movement on login screen + Guest -> Main Menu
//    @FXML
//    private void handleMouseEvent (MouseEvent event) {
//        if (event.getSource() == bntExit) {
//            System.exit(0); }
//        if (event.getSource().equals(btnBack))
//        { pgSignIn.toFront(); }
//
//    }
    @FXML
    public void cancelAction(ActionEvent actionEvent) {
        closeStage();
    }
    @FXML
    public void closeStage() {
        ((Stage) cancelBtn.getScene().getWindow()).close();
    }


    @FXML
    private void choicebox (MouseEvent event) {
        Object source = event.getSource();

            ObservableList<String> navnPåString = FXCollections.observableArrayList();

            for (Category k : Category.values()) {
                navnPåString.add(k.toString());
            }
            kategorich.setItems(navnPåString);
    }

    @FXML
    private void addprogramandcategory (ActionEvent event) {
        Object source = event.getSource();
    if (source==saveButton) {
        LoginFacade.addprogramkategori(kategorich.getSelectionModel().getSelectedItem().toString());
        LoginFacade.addprogram(nametf.getText());
    }
    }
}





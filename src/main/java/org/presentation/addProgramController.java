package org.presentation;

import domain.Facade.LoginFacade;
import domain.Program.Category;
import domain.Program.Program;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static domain.sysController.oProgramList;

public class addProgramController {

    @FXML
    private Button cancelButton;
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

    @FXML
    public void cancelAction(ActionEvent actionEvent) {
        closeStage();
    }
    @FXML
    public void closeStage() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
    @FXML void cancelWindow(MouseEvent mouseEvent){
        System.out.println(mouseEvent.getSource().toString());
        if (mouseEvent.getSource()==cancelButton){
            closeStage();
        }
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

            Program program = new Program(nametf.getText()); //opretter program--------------- har intet med producer at gøre

            oProgramList.add(program); //<- tilføjer til global liste af programmer alle kan se

            LoginFacade.addprogramkategori(kategorich.getSelectionModel().getSelectedItem().toString());
            LoginFacade.addprogram(nametf.getText()); // gemmer program i db

            closeStage();
        }
    }
}





package org.presentation;

import domain.user.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class adminController {

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
}
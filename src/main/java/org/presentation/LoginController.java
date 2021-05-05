package org.presentation;

import animatefx.animation.ZoomIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginController {


    @FXML
    private AnchorPane layersignup;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPass;
    @FXML
    private Button btnSignIn;
    @FXML
    private Button btnSignUp;
    @FXML
    private Pane pgSignUp;
    @FXML
    private Pane pgSignIn;
    @FXML
    private Button btnGoGuest;
    @FXML
    private Label txtInvalid;
    private ImageView imgBack;

    //Takes you from front login to sign up page (Don't have an account yet? Sign up)
    @FXML
    private void handleButtonAction (ActionEvent event) {
        if (event.getSource().equals(btnSignUp)) {
            new ZoomIn(pgSignUp).play();
            pgSignUp.toFront();
        }
    }

    //Movement on login screen + Guest -> Main Menu
    @FXML
    private void handleMouseEvent (MouseEvent event) {
        if (event.getSource().equals(imgBack)) {
            new ZoomIn(pgSignIn).play();
            pgSignIn.toFront(); }

    }
    // Guest -> Main Menu
    @FXML
    private void handleGuest (MouseEvent event) {
        if (event.getSource() == btnGoGuest) {
            closeStage();
            loadMain();
        }
    }

    @FXML
    private void handleSignIn (MouseEvent event) {
        String email = tfEmail.getText();
        String password = tfPass.getText();

        if (email.equals("demo") && password.equals("demo")) {
            closeStage();
            loadMain();
        }
        if (email.equals("producer") && password.equals("producer")) {
            closeStage();
            loadProducer();
        }
        if(email.isEmpty() || password.isEmpty()) {
            txtInvalid.setText("One or more text fields are empty. Try again!");
            txtInvalid.setStyle("-fx-background-color:#d32f2f;-fx-text-fill: white");
            }
    }
        /*
        if (event.getSource() == btnSignIn){
            if (tfEmail.getText() == null || tfEmail.getText().trim().isEmpty())
            else (tfPass.getText() == null || tfPass.getText().trim().isEmpty()) {
                System.out.println("Empty");
            }
*/

    private void loadProducer() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("producer.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Producer Panel");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException ex) {
        }
    }

    private void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("guest.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Menu");
            stage.setScene(new Scene(parent));
            stage.show();

        }
        catch (IOException ex) {
        }
    }

    public void closeStage() {
        ((Stage) btnSignIn.getScene().getWindow()).close();
    }
}




package org.presentation;


import animatefx.animation.ZoomIn;
import domain.Facade.LoginFacade;
import domain.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class loginController {


    @FXML
    public AnchorPane layersignup;
    @FXML
    public TextField tfEmail;
    @FXML
    public TextField tfPass;
    @FXML
    public Button btnSignIn;
    @FXML
    public Button btnSignUp;
    @FXML
    public Pane pgSignUp;
    @FXML
    public Pane pgSignIn;
    @FXML
    public Button btnBack;
    @FXML
    public RadioButton bntExit;
    @FXML
    public Button btnGoGuest;
    @FXML
    public Label txtInvalid;

    //Takes you from front login to sign up page (Don't have an account yet? Sign up)
    @FXML
    private void handleButtonAction (ActionEvent event) {
        if (event.getSource().equals(btnSignUp)) {
            pgSignUp.toFront();
        }
    }
    //Movement on login screen + Guest -> Main Menu
    @FXML
    private void handleMouseEvent (MouseEvent event) {
        if (event.getSource() == bntExit) {
            System.exit(0); }
        if (event.getSource().equals(btnBack))
        { pgSignIn.toFront(); }

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
        String username = tfEmail.getText();
        String password = tfPass.getText();


        User loggedIn = LoginFacade.login(username, password);
        if (loggedIn == null) {
            System.out.println("FAILURE");
        }
        else {
            switch (loggedIn.getType()) {
                case 1:
                    System.out.println("vis admin vindue");
                    break;
                case 2:
                    System.out.println("vis prod vindue");
                    break;
                case 3:
                    System.out.println("vis sheep vindue");
                    break;
                case 4:
                    System.out.println("user");
                    break;

            }
        }
    }


    private void handleSignUp (MouseEvent event) {
        String username = tfEmail.getText();
        String password = tfPass.getText();


        User loggedIn = LoginFacade.login(username, password);
        if (loggedIn == null) {
            System.out.println("FAILURE");
        }
        else {
            switch (loggedIn.getType()) {
                case 1:
                    System.out.println("vis admin vindue");
                    break;
                case 2:
                    System.out.println("vis prod vindue");
                    break;
                case 3:
                    System.out.println("vis sheep vindue");
                    break;
                case 4:
                    System.out.println("user");
                    break;

            }
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

    private void closeStage() {
        ((Stage) btnSignIn.getScene().getWindow()).close();
    }
}




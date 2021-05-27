package org.presentation;


import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOut;
import domain.Facade.LoginFacade;
import domain.sysController;
import domain.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static domain.sysController.session;
import static domain.sysController.userSession;


public class loginController {


    @FXML
    public AnchorPane layersignup;


    //Sign-up
    @FXML
    public TextField tfEmail;
    @FXML

    public PasswordField tfPass;

    public TextField tfPassword;
    @FXML
    public TextField tfAge;
    @FXML
    public TextField tfName;
    @FXML
    public TextField tfBusiness;
    @FXML
    private Label signUpInvalid;

    // Sign-in
    @FXML
    public TextField tfEmail1;

    @FXML
    public Button btnSignIn;
    @FXML
    public Button btnSignUp;
    @FXML
    public Button btnSignUp2;

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
    private Label signInInvalid;

    //Signup -> Login
    @FXML
    private void handleButtonAction (ActionEvent event) {
        if (event.getSource().equals(btnSignUp)) {
            new ZoomIn(pgSignUp).play();
            pgSignUp.toFront();
        }
    }
    //Login -> Signup
    @FXML
    private void handleMouseEvent (MouseEvent event) {
        new ZoomIn(pgSignIn).play();
        pgSignIn.toFront();
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
        String username = tfEmail1.getText();
        String password = tfPass.getText();

        User loggedIn = LoginFacade.login(username, password);

        if (loggedIn == null) {
            signInInvalid.setText("One or more textfields are incorrect. Try again!");
            signInInvalid.setStyle("-fx-background-color:#d32f2f;-fx-text-fill: white");
        }
        else {
            switch (loggedIn.getType()) {
                case 1:
                    System.out.println("type: "  + loggedIn.getType());
                    userSession = loggedIn.getType();
                    session = loggedIn; //-opmærksom på design konsekvens
                    closeStage();
                    loadMain();
                    System.out.println("vis logged in guest vindue");
                    break;

                case 2:
                    closeStage();
                    loadVerifiedProducer();
                    break;
                case 3:
                    closeStage();
                    loadAdmin();
                    break;
                case 4:
                    //System.out.println("user");
                    break;

            }
        }
    }

    @FXML
    private void signUpproducer(ActionEvent event) {

    }

    @FXML
    private void signUpUser(ActionEvent event) {
        Object source = event.getSource();
        if (source.equals(btnSignUp2)) {


           // if (tfAge.getText() == "" || tfPassword.getText() == "" || tfName.getText() == "" || tfEmail.getText() == "") {
             //   System.out.println("Missing info (Should be from message helper system)");
            if (tfAge.getText().trim().isEmpty() || tfPassword.getText().trim().isEmpty()|| tfName.getText().trim().isEmpty() || tfEmail.getText().isEmpty()) {
                signUpInvalid.setText("One or more text fields are empty. Try again!");
                signUpInvalid.setStyle("-fx-background-color:#d32f2f;-fx-text-fill: white");

        } else {
                String name = tfAge.getText();
                String password = tfPassword.getText();
                String userName = tfName.getText();
                String email = tfEmail.getText();
                //String business = tfBusiness.getText();
                System.out.println("user created!");
                User user = new User(name, userName, password, email);
                LoginFacade.addUser(user);
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

    private void loadVerifiedProducer() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("adminUI.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Registreret Producer");
            stage.setScene(new Scene(parent));
            stage.show();

        }
        catch (IOException ex) {
        }
    }

    private void loadAdmin() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("adminUI.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Admin");
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




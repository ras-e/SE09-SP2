package org.presentation;


import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOut;
import domain.Facade.LoginFacade;
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


public class loginController {


    @FXML
    public AnchorPane layersignup;


    //signup
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
    // sign in
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
    public Label txtInvalid1;

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
    private void handleSignIn (MouseEvent event) { //SignIn - tfEmail 1 + tfPass
        String username = tfEmail1.getText();
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

    @FXML
    private void signUpproducer(ActionEvent event) {

    }

    @FXML
    private void signUpUser(ActionEvent event) { //tfEmail - tfpassword
        Object source = event.getSource();
        if (source.equals(btnSignUp2)) {


            if (tfAge.getText() == "" || tfPassword.getText() == "" || tfName.getText() == "" || tfEmail.getText() == "") {
                System.out.println("Missing info (Should be from message helper system)");
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

    private void closeStage() {
        ((Stage) btnSignIn.getScene().getWindow()).close();
    }
}




package org.presentation;

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
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class loginController {


    @FXML
    public AnchorPane layersignup;
    @FXML
    public TextField tfEmail;
    @FXML
    public PasswordField tfPass;
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
    private PasswordField passSignUp;
    @FXML
    private TextField emailSignUp;
    @FXML
    private TextField nameSignUp;
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
    private void handleRegister(ActionEvent event){
        String email = emailSignUp.getText();
        String password = passSignUp.getText();
        String name = nameSignUp.getText();
        domain.users.AccountManager.createAccount(email, password, name);
    }

    @FXML
    private void handleSignIn (MouseEvent event) {
        String email = tfEmail.getText();
        String password = tfPass.getText();

        /*if (email.equals("demo") && password.equals("demo")) {
            closeStage();
            loadMain();
        }
        if (email.equals("producer") && password.equals("producer")) {
            closeStage();
            loadProducer();
        }*/
        if(email.isEmpty() || password.isEmpty()) {

            txtInvalid.setText("One or more text fields are empty. Try again!");
            txtInvalid.setStyle("-fx-background-color:#d32f2f;-fx-text-fill: white");
            }else{
            domain.users.AccountManager.checkLogin(email, password);
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




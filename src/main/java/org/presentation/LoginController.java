package org.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LoginController {

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

    //Takes you from front login to sign up page (Don't have an account yet? Sign up)
    @FXML
    private void handleButtonAction (ActionEvent event) {
        if (event.getSource().equals(btnSignUp)) {
            pgSignUp.toFront();
        }
    }
    //1st if statement: Exit system top left button, 2nd if: Takes you from sign up page -> Front login
    @FXML
    private void handleMouseEvent (MouseEvent event) {
        if (event.getSource() == bntExit) {
            System.exit(0); }
        if (event.getSource().equals(btnBack))
        { pgSignIn.toFront(); }

    }

    @FXML
    private void handleSignIn (MouseEvent event) {
        String email = tfEmail.getText();
        String password = tfPass.getText();
        // if(email.equal(va) && password.equal )
        if(email.isEmpty() || password.isEmpty()) {
            System.out.println("One or both fields are empty!");

        /*
        if (event.getSource() == btnSignIn){
            if (tfEmail.getText() == null || tfEmail.getText().trim().isEmpty())
            else (tfPass.getText() == null || tfPass.getText().trim().isEmpty()) {
                System.out.println("Empty");
            }
*/
        }
    }
}



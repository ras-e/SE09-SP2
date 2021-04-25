package org.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import domain.user.loginFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    public TextField userIdField;
    @FXML
    public TextField UserPsField;
    @FXML
    public Label messagelabel;

    loginFacade loginFacade = new loginFacade();

    HashMap<String, String> loginfo = new HashMap<String, String>();

    public LoginController(HashMap<String, String> LogInfoOriginal) {
        loginfo = LogInfoOriginal;
    }

    @FXML
    private void handleLogin (ActionEvent event) {
        if (event.getSource() == btnSignIn) {
            String username = userIdField.getText();
            String password = UserPsField.getText();
            if (loginFacade.tryLogin(username, password) == true) {
                messagelabel.setText("Login Success");
            } else {
                messagelabel.setText("WROOONG");
            }
        }
    }

        @FXML
        private void handleButtonAction (ActionEvent event){
            if (event.getSource().equals(btnSignUp)) {
                pgSignUp.toFront();
            }
        }

        @FXML
        private void handleMouseEvent (MouseEvent event){
            if (event.getSource() == bntExit) {
                System.exit(0);
            }
            if (event.getSource().equals(btnBack)) {
                pgSignIn.toFront();
            }
        }
    }




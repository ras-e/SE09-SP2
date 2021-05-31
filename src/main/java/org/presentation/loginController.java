package org.presentation;


import animatefx.animation.ZoomIn;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static domain.sysController.session;
import static domain.sysController.userSessionType;


public class loginController {

    @FXML
    public AnchorPane layersignup;
    //Sign-up
    @FXML
    public TextField tfEmail;
    @FXML
    public PasswordField tfPass;
    @FXML
    public TextField tfPassword;
    @FXML
    public TextField tfAge;
    @FXML
    public TextField tfName;
    @FXML
    public TextField tfBusiness;
    @FXML
    private Label signUpInvalid;
    @FXML
    private StackPane stackPane;
    @FXML
    private Button btnDialog;

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
    public Button btnGoGuest;
    @FXML
    private Label signInInvalid;

    //Signup -> Login
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource().equals(btnSignUp)) {
            new ZoomIn(pgSignUp).play();
            pgSignUp.toFront();
        }
    }

    //Login -> Signup
    @FXML
    private void handleMouseEvent(MouseEvent event) {
        new ZoomIn(pgSignIn).play();
        pgSignIn.toFront();
    }

    // Guest -> Main Menu
    @FXML
    private void handleGuest(MouseEvent event) {
        if (event.getSource() == btnGoGuest) {
            closeStage();
            loadMain();
        }
    }
    // Login (Facade + Session)
    @FXML
    private void handleSignIn(MouseEvent event) {
        String username = tfEmail1.getText();
        String password = tfPass.getText();
        User loggedIn = LoginFacade.login(username, password);

        if (loggedIn == null) {
            signInInvalid.setText("One or more textfields are incorrect. Try again!");
            signInInvalid.setStyle("-fx-background-color:#d32f2f;-fx-text-fill: white");
        } else {
            switch (loggedIn.getType()) {
                case 1:
                    System.out.println("type: " + loggedIn.getType());
                    userSessionType = loggedIn.getType();
                    session = loggedIn;
                    closeStage();
                    loadMain();
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
                    break;
            }
        }
    }


    @FXML
    private void signUpUser(ActionEvent event) {
        Object source = event.getSource();
        if (source.equals(btnSignUp2)) {

            if (tfAge.getText().trim().isEmpty() || tfPassword.getText().trim().isEmpty() || tfName.getText().trim().isEmpty() || tfEmail.getText().isEmpty()) {
                signUpInvalid.setText("One or more text fields are empty. Try again!");
                signUpInvalid.setStyle("-fx-background-color:#d32f2f;-fx-text-fill: white");

            } else {
                String name = tfAge.getText();
                String password = tfPassword.getText();
                String userName = tfName.getText();
                String email = tfEmail.getText();
                System.out.println("User created!");
                User user = new User(name, userName, password, email);
                LoginFacade.addUser(user);
            }
        }
    }

    @FXML
    public void loadInfo(ActionEvent event) {
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Data Policy");
        alert1.setHeaderText("Data Privacy");
        alert1.setContentText(
                "We only collect the information you choose to give us, and we process it with your consent, or on another legal basis; " +
                "we only require the minimum amount of personal information that is necessary to fullfill the purpose of your interaction with us. " +
                "\n We comply with any data regulations and compliant with GDPR at any time.");
        alert1.setResizable(true);
        alert1.getDialogPane().setPrefSize(500, 200);
        alert1.showAndWait();
    }

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




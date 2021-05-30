package org.presentation;

import domain.Facade.LoginFacade;
import domain.Program.Credits;
import domain.Program.Program;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;
import java.util.Optional;

import static domain.sysController.*;


public class GuestController {
    @FXML
    private RadioButton programButton;
    @FXML
    private RadioButton personButton;
    @FXML
    private RadioButton kreditButton;
    @FXML
    private ListView searchView;
    @FXML
    private TextField searchTextField;
    @FXML
    private Button btnLogin;
    @FXML
    private Button delUser;
    @FXML
    private Button btnGdpr;
    @FXML
    private Label lSearchResults;
    @FXML
    private Button favPro;

    @FXML
    public void initialize(){
        //initialize some test data for guests to view:
        for (int i = 0; i < 10; i++) {
            oProgramList.add(new Program("dbz episode "+i));
            createmvPerson("Jens"+i,"jensen");
            oCreditList.add(new Credits());

            if (userSessionType == 1){
                btnLogin.setVisible(false);
            } else if (userSessionType == 0) {
                delUser.setVisible(false);
                btnGdpr.setVisible(false);
                favPro.setVisible(false);
            }

        }
    }

    public void PPKselect(MouseEvent event){
        lSearchResults.setText("Søgeresultater");
        if(event.getSource().equals(personButton)){
            searchView.setItems(oPersonList);
        } else if (event.getSource().equals(programButton)) {
            searchView.setItems(oProgramList);
        } else if (event.getSource().equals(kreditButton)){
            searchView.setItems(oCreditList);
        }
    }

    public void searchViewFilter(KeyEvent event){

    }
    @FXML
    private void goLoginPage (MouseEvent event) {
        if(event.getSource() == btnLogin) {
            closeStage();
            loadWindow("Logins.fxml","Login");
        }
    }
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
    public void closeStage() {
        ((Stage) btnLogin.getScene().getWindow()).close();
    }

    //Delete user info & Alert function (GDPR related)
    public void delUserRequest(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("ATTENTION: DO YOU WANT TO PROCEED?\n" +
                "THIS WILL DELETE YOUR ACCOUNT AND ALL ITS RELATED DETAILS.");
        alert.setContentText("In accordance with GDPR we provide the option to delete your account and related information\n\n" +
                "Pressing 'OK' will delete all details saved of you AND your acc. \n" +
                "If you change your mind press 'CANCEL'\n\n" +
                "We at TV 2 care highly about your private details. Feel free to sign up again and enjoy all the benefits as a registered user");

        Optional<ButtonType> result = alert.showAndWait();

        // ... user chose OK
        if (result.get() == ButtonType.OK){
            LoginFacade.delUser(session);
            searchView.setItems(oProgramList);

        } else {
            // ... user chose CANCEL or closed the dialog
            if (result.get() == ButtonType.CANCEL);
        }
    }

    //Print user info
    public void showGDPR(MouseEvent event){
        searchView.setItems(session.returnUserInf());
        System.out.println(session.returnUserInf());

        lSearchResults.setText("Konto information");
    }

    public void logUd (){
        closeStage();
        loadWindow("Logins.fxml","Login");
    }

}

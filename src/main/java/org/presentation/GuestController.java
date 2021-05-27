package org.presentation;

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

import static domain.sysController.*;


public class GuestController {
    @FXML
    public RadioButton programButton;
    @FXML
    public RadioButton personButton;
    @FXML
    public RadioButton kreditButton;
    @FXML
    public ListView searchView;
    @FXML
    public TextField searchTextField;
    @FXML
    public Button btnLogin;
    @FXML
    public Button delBrugerInf;
    @FXML
    public Button btnGdpr;
    @FXML
    public Label lSearchResults;

    @FXML
    public void initialize(){
        //initialize some test data for guests to view:
        for (int i = 0; i < 10; i++) {
            oProgramList.add(new Program("dbz episode "+i));
            createmvPerson("Jens"+i,"jensen");
            oCreditList.add(new Credits());

            if (userSession == 1){
                btnLogin.setVisible(false);
            } else if (userSession == 0) {
                delBrugerInf.setVisible(false);
                btnGdpr.setVisible(false);
            }

        }
//        Search filter work in progress
//        FilteredList<mvPerson> fPersonList = new FilteredList<>(FXCollections.observableArrayList(oPersonList));
//        fPersonList.setPredicate(p ->{
//            return true;
//        });
//        searchView.setItems(fPersonList);
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

    //delete user info
    public void delUserRequest(){
        System.out.println("delete logging user info");
    }

    //show user info
    public void showGDPR(MouseEvent event){
        searchView.setItems(session.returnUserInf());
        System.out.println(session.returnUserInf());

        lSearchResults.setText("Konto information");
    }

    public void logUd (){
        closeStage();
        loadWindow("LLogin.fxml","Login");
    }

}

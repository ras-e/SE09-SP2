package org.presentation;

import domain.Program.Credits;
import domain.Program.Program;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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


//        Search filter work in progress
//        FilteredList<mvPerson> fPersonList = new FilteredList<>(FXCollections.observableArrayList(oPersonList));
//        fPersonList.setPredicate(p ->{
//            return true;
//        });
//        searchView.setItems(fPersonList);




//    public void PPKselect(MouseEvent event){
//        if(event.getSource().equals(personButton)){
//            searchView.setItems(oPersonList);
//        } else if (event.getSource().equals(programButton)) {
//            searchView.setItems(oProgramList);
//        } else if (event.getSource().equals(kreditButton)){
//            searchView.setItems(oCreditList);
//        }
//    }

    public void searchViewFilter(KeyEvent event){

    }
    @FXML
    private void goLoginPage (MouseEvent event) {
        if(event.getSource() == btnLogin) {
            closeStage();
            loadWindow("login.fxml","Login");
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


}

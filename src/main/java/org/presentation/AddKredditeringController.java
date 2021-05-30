package org.presentation;

import com.jfoenix.controls.JFXButton;
import domain.Program.Credits;
import domain.Program.mvPerson;
import domain.Program.tvProdRolle;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static domain.sysController.*;
import static org.presentation.PresentationHelper.choiceboxRollePopulate;

public class AddKredditeringController {


    public TextField email;
    public TextField country;
    public TextField inProgram;
    public TextField name;
    public TextField date;
    public TextField role;

    public TextField tfFornavn;
    public TextField tfEfternavn;
    public JFXButton saveButton;
    public JFXButton cancelButton;
    public JFXButton opretPerson;
    public ChoiceBox personBox;
    public ChoiceBox rolleBox;
    public JFXButton opretKredittering;



    public void cancelAction(ActionEvent actionEvent) {
        closeStage();
    }

    public void saveButton(MouseEvent actionEvent) {
        closeStage();
    }
    private void closeStage() { ((Stage) cancelButton.getScene().getWindow()).close();  }

    public void initialize(){
        personBox.setItems(oPersonList);
    }

    public void opretPerson(MouseEvent event){
        mvPerson nyPerson = new mvPerson(tfFornavn.getText(),tfEfternavn.getText());
        oPersonList.add(nyPerson);
        System.out.println("person oprettet: "+nyPerson.getname());
        personBox.setItems(oPersonList);
    }

    public void personBox(MouseEvent event){
        System.out.println("personboxclick");

    }

    public void rolleBox(MouseEvent event){
        choiceboxRollePopulate(rolleBox);
    }

    public void opretKredittering(){

        tvProdRolle enRolle = tvProdRolle.valueOf((String) rolleBox.getValue());

        mvPerson enPerson = (mvPerson) personBox.getValue();

        Credits enKredittering = new Credits(enRolle, enPerson);

        oCreditList.add(enKredittering);
        //currentProgram.addCredit(enKredittering);
        currentProgram.addCredit(enKredittering);
        System.out.println(currentProgram);
        System.out.println(currentProgram.getCredits().size());

        //System.out.println("En kredditering: "+enKredittering);

    }


}

package org.presentation;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class producerController {

    @FXML
    public Button add;
    @FXML
    public RadioButton programButton;
    @FXML
    public RadioButton personButton;
    @FXML
    public RadioButton kredditeringButton;
    @FXML
    public TextField searchTextField;



    public void handleMouseAction(MouseEvent mouseEvent) {
        boolean programSelected = programButton.isSelected();
        boolean personSelected = personButton.isSelected();
        boolean krediteringSelected = kredditeringButton.isSelected();

        if (mouseEvent.getSource() == add ) {
            if (personSelected) {

                System.out.println("person"); //-> skriv person til en value og lav en form for property binding så det der står på listen reflectree værdi

            } else if (programSelected) {
                System.out.println("program");

            } else if (krediteringSelected) {
                System.out.println("kreditering");
            }

            System.out.println(searchTextField.getCharacters());
                //if no program type is seleceted throw error


            //check hvilken case der er valgt -> læs tekst i felt -> gem tekst til appropiate sted
        }
    }



}

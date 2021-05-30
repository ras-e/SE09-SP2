package org.presentation;

import domain.Program.Credits;
import domain.Program.Program;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import static domain.sysController.currentProgram;
import static domain.sysController.oProgramList;
import static org.presentation.PresentationHelper.loadWindows;


public class ProducerController {

    @FXML
    private ChoiceBox programListBox;
    @FXML
    private ListView creditListView;
    @FXML
    private Button addKredditeringBtn;
    @FXML
    private Button editKreditteringBtn;
    @FXML
    Button delKreditteringBtn;


    public void initialize(){
        System.out.println("init");
        programListBox.setItems(oProgramList);
        addKredditeringBtn.setVisible(false);
        editKreditteringBtn.setVisible(false);
        delKreditteringBtn.setVisible(false);
    }

    public void addKredditering(){
       loadWindows("addKredittering.fxml","Tilføj kredittering");
    }

    public void programListClick(){
        currentProgram = (Program) programListBox.getValue();
        if(currentProgram!=null){

            //Vis currentprogram i tabelview
            ObservableList<Credits> oCurrentProgramCredits = FXCollections.observableArrayList(currentProgram.getCredits());
            creditListView.setItems(oCurrentProgramCredits);
            addKredditeringBtn.setVisible(true);
            editKreditteringBtn.setVisible(true);
            delKreditteringBtn.setVisible(true);

        }
    }
    public void updateListView(){}
}

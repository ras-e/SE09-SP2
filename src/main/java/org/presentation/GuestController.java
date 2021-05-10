package org.presentation;

import domain.Program.Credits;
import domain.Program.Program;
import domain.Program.mvPerson;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    public void initialize(){
        //initialize some test data for guests to view:
        for (int i = 0; i < 10; i++) {
            oProgramList.add(new Program("dbz episode "+i));
            createmvPerson("Jens"+i,"jensen");
            oCreditList.add(new Credits());



        }
        //Search filter work in progress
        FilteredList<mvPerson> fPersonList = new FilteredList<>(FXCollections.observableArrayList(oPersonList));
        fPersonList.setPredicate(p ->{
            return true;
        });
        searchView.setItems(fPersonList);
    }



    public void PPKselect(MouseEvent event){
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

}

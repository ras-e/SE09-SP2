package org.presentation;

//Iteration 1 - Skrive til fil


/*
import domain.Facade.ProducerFacade;
import domain.Program.Program;
import domain.Program.mvPerson;
import domain.Program.tvProdRolle;
import domain.user.Producer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import static domain.sysController.createmvPerson;
import static domain.sysController.getmvPersons;


public class ProducerControllerOld {

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
    @FXML
    public ChoiceBox addCreditDropdown;
    @FXML
    public ListView creditView;


//    @FXML
//    public ObservableMap<mvPerson, tvProdRolle> creditList;
    @FXML
    public ObservableList<String> creditString = FXCollections.observableArrayList("option 1");
    @FXML
    public TextField tfusername;
    @FXML
    public TextField tfname;
    @FXML
    public TextField tfemail;
    @FXML
    public TextField tfid;
    @FXML
    public TextField tftype;
    @FXML
    public TextField tfpassword;
    @FXML
    public TextField tfbusiness;

    @FXML
    private void initialize() {

      
    ObservableList<mvPerson> personList = FXCollections.observableArrayList();
    @FXML
    ObservableList<Program> programList = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
       addCreditDropdown.setItems(creditString);
       creditView.setItems(programList); //<- ændre fra creditview til program view eller fra programlist til creditList

    }

    public void handleMouseAction(MouseEvent mouseEvent) {
        boolean programSelected = programButton.isSelected();
        boolean personSelected = personButton.isSelected();
        boolean krediteringSelected = kredditeringButton.isSelected();

        if (mouseEvent.getSource() == add) {
            if (personSelected) {

                //mvPerson person = new mvPerson(searchTextField.getCharacters().toString()); //<-
                //System.out.println(createmvPerson(searchTextField.getCharacters().toString(),"efternavn"));
                createmvPerson(searchTextField.getCharacters().toString(),"kek");
                System.out.println(getmvPersons());



            } else if (programSelected) {

                Program program = new Program(searchTextField.getCharacters().toString());
                programList.add(program);

                System.out.println(program.toString());
                System.out.println(getmvPersons());


            } else if (krediteringSelected) {
                //brug andet setup
            }

            //System.out.println(searchTextField.getCharacters());
            //if no program type is seleceted throw error
            //check hvilken case der er valgt -> læs tekst i felt -> gem tekst til appropiate sted
        }
    }

        @FXML
        private void createProducer (MouseEvent event){
            int id =  Integer.parseInt(tfid.getText());
            int type =  Integer.parseInt(tftype.getText());
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String email = tfemail.getText();
            String business = tfbusiness.getText();


            Producer producer = new Producer(id, name, username, password, email, business, type);
           // ProducerFacade.addedProd()
//            @FXML
//            public void handleCreditAdd (MouseEvent event){
//                System.out.println();
//            }


        }
    }
*/

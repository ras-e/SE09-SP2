package org.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CrudController {

    //Til listview og textarea
    @FXML private ListView listView;
    @FXML private TextArea TextArea;
    @FXML private Button btnInsert;
    @FXML private Button btnUpdate;
    @FXML private Button btnDelete;
    @FXML private TextField tfid;
    @FXML private TextField tfTitle;
    @FXML private TextField tfParticipants;
    @FXML private TextField tfYear;
    @FXML private TextField tfProgram;



    //Skal være fil med krediteringslister
    @FXML
    private void handleMouseEvent (MouseEvent event) {
        //if (event.getSource() == ) {
        //System.exit(0); }

    }
}

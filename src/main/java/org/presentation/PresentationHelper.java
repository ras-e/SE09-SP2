package org.presentation;

import domain.Program.Program;
import domain.Program.tvProdRolle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

import static domain.sysController.oProgramList;

public class PresentationHelper {
    public static void populateChoiceBox() {
    }

    public static void populateRolleBox() {
    }

    public static void loadWindows(String path, String title) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(PresentationHelper.class.getResource(path)));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void choiceboxRollePopulate (ChoiceBox choiceBox) {
        ObservableList<String> cbList = FXCollections.observableArrayList();

        for (tvProdRolle k : tvProdRolle.values()) {
            cbList.add(k.toString());
        }
        choiceBox.setItems(cbList);
    }

    public static void choiceboxProgramPopulate(){
        for(Program p: oProgramList){
            System.out.println("kek");
        }
    }


}


package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static com.example.pediatendprimary.Main.*;

public class MostRecentVitals {

    public MostRecentVitals() {}

    Label vitalsTitle = new Label("Jean Deaux's Visit on mm/dd/yyyy");

    TextArea vitalsDisplayArea = new TextArea(
            "Weight: \n" +
            "Body Temperature: \n" +
            "Diagnosis: \n" +
            "Methodology: \n" +
            "Advice: \n" +
            "Prescriptions: \n");

    Button back = new Button("Back");

    VBox mainWrapper = new VBox(20, vitalsTitle, vitalsDisplayArea, back);

    StackPane RecentVitalsPane = new StackPane(mainWrapper);
    Scene RecentVitalsScene = new Scene(RecentVitalsPane, 640, 480); // 4:3

    public void set() {

        vitalsTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));

        RecentVitalsPane.setStyle("-fx-background-color: gray;");
        RecentVitalsPane.setAlignment(Pos.CENTER);
        RecentVitalsPane.setPadding(new Insets(125));

        mainWrapper.setAlignment(Pos.CENTER);

        vitalsDisplayArea.setDisable(true);
        vitalsDisplayArea.setMinSize(200, 200);

        setPatientVisit();

        back.setStyle(BUTTON_STYLE);

        back.setMinSize(75, 30);

        back.setOnAction((event) -> {
            patientHub.set();
        });

        mainStage.setScene(RecentVitalsScene);
    }

    public void setPatientVisit(){
        // Makes sure that the title has the correct name and date
        //Need database for this
    }
}

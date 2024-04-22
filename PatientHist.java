package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import com.example.pediatendprimary.stash.Patient;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static com.example.pediatendprimary.Main.*;

public class PatientHist {
    // String allergiesStr = patient.getAllergies(), concernsStr = patient.getHealthConcerns();

    Text title = new Text("PediaTend");
    HBox titleBox = new HBox(title); // add the logo icon too

    Label patName = new Label("Patient: Jean Deaux");
    Label patAge = new Label("Age: 8 years 4 months");
    VBox patVB = new VBox(patName, patAge);
    TextArea diagnosis = new TextArea();
    TextArea prescriptions = new TextArea();
    TextArea immunizations = new TextArea();
    TextArea visits = new TextArea("Patient's visits here.\nAccess using the getter");

    VBox boxA = new VBox(new Label("Health Issues:"), diagnosis),
         boxB = new VBox(new Label("Prescriptions:"), prescriptions),
         boxC = new VBox(new Label("Immunization:"), immunizations),
         boxD = new VBox(new Label("Visits:"), visits);

    Button back = new Button("Back");
    Button save = new Button("Save");
    HBox buttons = new HBox(100, back, save);
    HBox textAreas = new HBox(boxA, boxB, boxC, boxD);


    VBox center = new VBox(patVB, textAreas);
    // BorderPane(center, top, right, bottom, left)

    BorderPane content = new BorderPane(center, titleBox, null, buttons, null);

    Scene scene = new Scene(content, 640, 480); // 4:3


    public void set()
    {
        titleBox.setAlignment(Pos.CENTER);
        patVB.setAlignment(Pos.TOP_LEFT);
        buttons.setAlignment(Pos.CENTER);

        patName.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
        patAge.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
        patName.setStyle("-fx-background-color: dimgray;");
        patAge.setStyle("-fx-background-color: dimgray;");

        back.setStyle(BUTTON_STYLE);

        diagnosis.setEditable(false);
        immunizations.setEditable(false);
        prescriptions.setEditable(false);
        visits.setEditable(false);

        back.setOnAction(e-> {
            patientHub.set();
        });

        Main.mainStage.setScene(scene);
    }

    public void fillHealthConcernArea(String diagnosisText){
        diagnosis.appendText(diagnosisText);
    }
    public void fillPrescriptionArea(String prescriptionText){
        prescriptions.appendText(prescriptionText);
    }
    public void fillImmunizationArea(String immunizationText){
        immunizations.appendText(immunizationText);
    }
    public void fillTextAreas(Patient patient){
        diagnosis.appendText(patient.getHealthConcerns());
        immunizations.appendText(patient.getImmunizations());
        prescriptions.appendText(patient.getPrescriptions());
        //visits.appendText(patient.getPastVisits());           convert visits to string before appending to text
    }
}
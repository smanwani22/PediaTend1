package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import com.example.pediatendprimary.stash.Patient;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static com.example.pediatendprimary.Main.*;


public class DoctorDiagnosis {
    Patient patient;

    public DoctorDiagnosis(Patient patient) { // New constructor taking a Patient object
        this.patient = patient;
    }
    //public DoctorDiagnois(){}


    Text title = new Text("PediaTend");
    String fName;
    String lName;
    int age;

    Label patientNameLabel = new Label("Patient: ");

    Label patientAgeLabel = new Label("Age: ");
    Label date = new Label("Date: ");
    Label diagnosisLabel = new Label("Diagnosis: ");
    Label methodologyLabel = new Label("Methodology: ");
    Label prescriptionsLabel = new Label("Prescriptions: ");
    Label immunizationLabel = new Label ("Immunizations: ");
    Label adviceLabel = new Label("Advice/Care: ");

    TextField diagnosisField = new TextField();
    String diagnosisText = diagnosisField.getText();
    TextField methodologyField = new TextField();
    TextField prescriptionsField = new TextField();
    String prescriptionsText = prescriptionsField.getText();

    TextField adviceField = new TextField();
    TextField immunizationField = new TextField();
    String immunizationText = immunizationField.getText();


    Button patientDetail = new Button("See Patient Detail");
    Button proceed = new Button("Proceed");
    //ToggleButton yesButton = new ToggleButton("Yes");
    //ToggleButton noButton = new ToggleButton("No");
    //Label immunizationOrNo = new Label ("Were there any immunizations?");
    Button vitals = new Button ("Vitals");
    Button back = new Button("Back");

    HBox titleBox = new HBox(title);
    VBox patientInfo = new VBox(10, patientNameLabel, patientAgeLabel, date);
    VBox diagnosisBox = new VBox(10, diagnosisLabel, diagnosisField);
    VBox methodologyBox = new VBox(10, methodologyLabel, methodologyField);
    VBox prescriptionsBox = new VBox(10, prescriptionsLabel, prescriptionsField);
    VBox adviceBox = new VBox(10, adviceLabel, adviceField);
    VBox immunizationBox = new VBox(10, immunizationLabel, immunizationField);
    HBox buttonsBox = new HBox(30, patientDetail, vitals, proceed, back);
    //HBox yesNoImmunizations = new HBox(immunizationOrNo, yesButton, noButton);

    VBox completeDiagnosis = new VBox(5, diagnosisBox, methodologyBox, prescriptionsBox, immunizationBox, adviceBox);
    StackPane diagnosisPane = new StackPane(completeDiagnosis, titleBox, buttonsBox, patientInfo);
    Scene diagnosisScene = new Scene(diagnosisPane, 640, 480);

    Patient currentPatient = patienFound;
    public void setPatientDiagnosis(){
       diagnosisText = diagnosisField.getText();
       currentPatient.setHealthConcerns(diagnosisText);
    }
    public void setPatientPrescriptions(){
        prescriptionsText = prescriptionsField.getText();
        currentPatient.setPrescriptions(prescriptionsText);
    }

    public void setPatientImmunizations(){
        immunizationText = immunizationField.getText();
        currentPatient.setImmunizations(immunizationText);
    }

    public void set() {
        //noButton.setSelected(true);
        diagnosisPane.setStyle("-fx-background-color: gray;");
        proceed.setStyle(BUTTON_STYLE);
        patientDetail.setStyle(BUTTON_STYLE);
        vitals.setStyle(BUTTON_STYLE);
        back.setStyle(BUTTON_STYLE);

        title.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 25));
        titleBox.setAlignment(Pos.TOP_RIGHT);
        titleBox.setPadding(new Insets(25));

        patientInfo.setAlignment(Pos.TOP_LEFT);
        patientInfo.setPadding(new Insets(25, 0, 0, 25));

        completeDiagnosis.setAlignment(Pos.CENTER);
        completeDiagnosis.setPadding(new Insets(50));

        buttonsBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonsBox.setPadding(new Insets(0, 10, 25, 0));


        proceed.setOnAction(actionEvent -> {
            setPatientDiagnosis();
            setPatientPrescriptions();
            setPatientImmunizations();
            patientHist.set();
        });

        patientDetail.setOnAction(actionEvent -> {
            patientHist.set();
        });

        //ADD AN IF Statement here because it will set to the right page depending on
        //the patient's age, which we will get from database
        vitals.setOnAction(actionEvent -> {
            vitalEntry12Up.set();
        });

        back.setOnAction(e-> {
            patientDirectory.set();
        });

        Main.mainStage.setScene(diagnosisScene);
    }

    public void setPatientInfo(){
        //Pull from database: name and age
    }

//Database needed to set the date and add the date to visits in PatientHist class
    public void seePatientDetail(){
        //makes sure to take the doctor to the correct patient's health history
}
                                                                                                                                                        //Not sure what this means; proceed button takes them to health history.  Verifying
    //correct patient is done at the patient selection step

    public void clearText(){
        //clears text
    }
    //Don't believe this method is necessary
}

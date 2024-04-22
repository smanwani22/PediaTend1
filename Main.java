package com.example.pediatendprimary;

import com.example.pediatendprimary.pages.*;
import com.example.pediatendprimary.stash.Patient;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainStage = primaryStage;
        mainStage.setTitle("PediaTend");
        loginPage.set();
        mainStage.show();

    }

    public static Stage mainStage;
    public static Patient patienFound = new Patient();
    public static LoginPage loginPage = new LoginPage();
    public static SignUpPage signUpPage = new SignUpPage();
    public static PatientHub patientHub = new PatientHub();
    public static PatientMessages patientMessages = new PatientMessages();
    public static DoctorMessages doctorMessages = new DoctorMessages();
    public static NurseMessages nurseMessages = new NurseMessages();
    public static VitalEntry12Up vitalEntry12Up = new VitalEntry12Up();
    public static VitalEntry12Down vitalEntry12Down = new VitalEntry12Down();
    public static MostRecentVitals mostRecentVitals = new MostRecentVitals();
    public static NurseHub nurseHub = new NurseHub();
    public static DoctorHub doctorHub = new DoctorHub();
    public static Patient patient = new Patient("Jon", "Doe", "jondoe@gmail.com", "abc123", "2023", "3", "4");
    public static DoctorDiagnosis doctorDiagnosis = new DoctorDiagnosis(patient);

    public static PatientContactInfo patientContactInfo = new PatientContactInfo();
    public static PatientContactInfoDV patientContactInfoDV = new PatientContactInfoDV();
    public static PatientDirectory patientDirectory = new PatientDirectory();

    public static PatientHist patientHist = new PatientHist();

    public static final String BUTTON_STYLE = "-fx-background-color: dimgrey;\n" +
            "     -fx-background-radius: 30;\n" +
            "     -fx-background-insets: 0;\n" +
            "     -fx-text-fill: #CCCCCC;";

}

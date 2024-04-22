package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import com.example.pediatendprimary.stash.Patient;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;

import static com.example.pediatendprimary.Main.*;
import static com.example.pediatendprimary.pages.PatientContactInfo.primaryInteractor;

public class PatientDirectory {
    int counter = 0;
    final File databaseFiles = new File("databaseFiles");
    BorderPane border = new BorderPane();

    Label title = new Label("Patient Directory");
    //set button names to be names of patients/dob
    //iterate through DB

    Button tf1 = new Button("Patient A, mm/dd/yyyy");
    Button tf2 = new Button("Patient B, mm/dd/yyyy");
    Button tf3 = new Button("Patient C, mm/dd/yyyy");
    Button tf4 = new Button("Patient D, mm/dd/yyyy");
    Button tf5 = new Button("Patient E, mm/dd/yyyy");
    Button tf6 = new Button("Patient F, mm/dd/yyyy");
    Button tf7 = new Button("Patient G, mm/dd/yyyy");
    Button tf8 = new Button("Patient H, mm/dd/yyyy");
    Button tf9 = new Button("Patient I, mm/dd/yyyy");
    Button tf10 = new Button("Patient J, mm/dd/yyyy");
    Button tf11 = new Button("Patient K, mm/dd/yyyy");
    Button tf12 = new Button("Patient L, mm/dd/yyyy");
    Button tf13 = new Button("Patient M, mm/dd/yyyy");
    Button tf14 = new Button("Patient N, mm/dd/yyyy");
    Button tf15 = new Button("Patient O, mm/dd/yyyy");
    Button tf16 = new Button("Patient P, mm/dd/yyyy");
    Button tf17 = new Button("Patient Q, mm/dd/yyyy");
    VBox vbox = new VBox();
    //VBox vbox = new VBox();
    Button diagnosis = new Button("Diagnosis");
    Button enterVitals = new Button("Enter Vitals");
    Button contactInfo = new Button("Contact Info");
    Button back = new Button("Back");
    HBox titleBox = new HBox(200, back, title);
    HBox bottomButtons = new HBox(5,diagnosis,enterVitals,contactInfo);
    TextArea patientInfo = new TextArea("<patient health history, phone number>");
    ScrollPane scrollPane = new ScrollPane();           //change to list view
    Scene PatientDirectoryScene = new Scene(border, 640, 480);

    public static PatientContactInfoDV PatientContactInfoDV = new PatientContactInfoDV();

    public void set() {
        buttonMother(databaseFiles);
        border.setTop(titleBox);
        BorderPane.setAlignment(title, Pos.CENTER);
        border.setPadding(new Insets(30, 20, 20, 20));
        border.setStyle("-fx-background-color: gray;");

        contactInfo.setStyle(BUTTON_STYLE);
        diagnosis.setStyle(BUTTON_STYLE);

        //for the length of buttons array list
        int i = 0;
        for (Button buttonBaby : buttonBabies) {
            vbox.getChildren().addAll(buttonBaby);
            buttonBaby.setPrefWidth(200);
            buttonBaby.setOnAction(e -> {              //example button of what's expected when selecting patient
                //show patient info
                //set patient info to 1st line in patient file
                try {
                    patientInfo.setText(primaryInteractor.readFile(buttonBaby.getText()));
                } catch (NoSuchAlgorithmException | FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                border.setCenter(patientInfo);
                border.setBottom(bottomButtons);
                BorderPane.setAlignment(bottomButtons, Pos.TOP_RIGHT);
                //nameButton(databaseFiles);
            });
            i++;
        }

        scrollPane.setPrefViewportWidth(200);

        scrollPane.setContent(vbox);

        border.setLeft(scrollPane);

        bottomButtons.setAlignment(Pos.CENTER_RIGHT);

        patientInfo.setEditable(false);

        contactInfo.setOnAction(e-> {
            PatientContactInfoDV.set();
        });

        diagnosis.setOnAction(e-> {
            doctorDiagnosis.set();
        });
        int finalI = i;
        enterVitals.setOnAction(e-> {
            try {
                primaryInteractor.readFile(buttonBabies.get(0).getText());
            } catch (NoSuchAlgorithmException | FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            vitalEntry12Up.set();
        });

        back.setOnAction(e-> {
            patientHub.set();
        });
        //enter vitals button must first check age of selected patient
       // ^^Doesn't make sense to have an enter vitals when the patient isn't even selected
        Main.mainStage.setScene(PatientDirectoryScene);
    }

    public void addToList(ArrayList<Patient> patientsList){
        for(int i = 0; i < patientsList.size(); i++){
            Button buttons = new Button(patientsList.get(i).firstName + " " + patientsList.get(i).lastName + " " + patientsList.get(i).email);
            buttons.setPrefWidth(200);
            vbox.getChildren().addAll(buttons);
            buttons.setOnAction(e -> {              //example button of what's expected when selecting patient
                //show patient info
                border.setCenter(patientInfo);
                border.setBottom(bottomButtons);
                BorderPane.setAlignment(bottomButtons, Pos.TOP_RIGHT);
            });
        }
        //adds patients from database to patient directory page
    }
    public void find(ArrayList<Patient> patients, String fName, String lName, String email) {
        for(int i = 0; i < patients.size(); i++){
            if(patients.get(i).firstName.equals(fName) && patients.get(i).lastName.equals(lName) && patients.get(i).email.equals(email)) {
                patienFound = patients.get(i);
            }
        }
    }
    //See if we need to create a function that correctly adds patients with their name and bday
    ArrayList<String> patientButtons = new ArrayList<String>();
    public void buttonMother(final File databaseFiles) {
        int i = 0;
        for (final File patientFile : Objects.requireNonNull(databaseFiles.listFiles())) {
            //put these into an arrays, then array[i] = new button[i] to be displayed

            buttonBabies.add(new Button(patientFile.getName().substring(3,patientFile.getName().length()-3)));
            //System.out.println(buttonBabies.get(i).getText());
            i++;
        }
    }
    ArrayList<Button> buttonBabies = new ArrayList<Button>();
    ArrayList<Patient> patients = new ArrayList<Patient>();
//    public void buttonPatients() throws FileNotFoundException, NoSuchAlgorithmException {   //attach people to buttons
//        for (int i = 0; i < Objects.requireNonNull(databaseFiles.listFiles()).length; i++) {
//            patients.set(i,primaryInteractor.readFile(databaseFiles));
//        }
//    }
}

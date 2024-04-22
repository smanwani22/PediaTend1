package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import com.example.pediatendprimary.stash.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

import static com.example.pediatendprimary.Main.*;

public class PatientContactInfoDV {
    public PatientContactInfoDV(){}

    Label emailLabel = new Label("email:   ");
    TextField email = new TextField("jeandeaux@aol.com");

    Label phoneLabel = new Label("phone: ");
    TextField phone = new TextField("641-425-6092");

    Label title = new Label();
    HBox emailBox = new HBox(5,emailLabel,email);
    HBox phoneBox = new HBox(5,phoneLabel,phone);
    VBox contactInfo = new VBox(10,emailBox,phoneBox);
    Button back = new Button("Back");
    HBox bottomButtons = new HBox(10,back);
    BorderPane border = new BorderPane();
    Scene PatientContactInfoDVScene = new Scene(border,640,480);
    public static PatientDirectory PatientDirectory = new PatientDirectory();
    public void set() {
        email.setEditable(false);
        phone.setEditable(false);       //false unless select edit button

        border.setTop(title);
        title.setStyle("-fx-font: 16 verdana");
        BorderPane.setAlignment(title,Pos.CENTER);

        border.setPadding(new Insets(30,20,20,20));

        BorderPane.setAlignment(contactInfo,Pos.CENTER);
        emailBox.setAlignment(Pos.CENTER);
        phoneBox.setAlignment(Pos.CENTER);
        border.setCenter(contactInfo);
        contactInfo.setAlignment(Pos.CENTER);

        //bottomButtons.setAlignment(Pos.CENTER);
        border.setBottom(bottomButtons);

        back.setStyle(BUTTON_STYLE);

        back.setOnAction(e -> {
            PatientDirectory.set();
        });
        border.setStyle("-fx-background-color: gray;");
        Main.mainStage.setScene(PatientContactInfoDVScene);
    }

    public void getContactInfo(ArrayList<Patient> patients) {
        title.setText(patients.get(2).firstName + " " + patients.get(2).lastName + "'s contact information");       //.get(2) is temporary while trying to find right patient
        email.appendText(patients.get(2).email);
        phone.appendText(patients.get(2).email);        //change to phone number
        //You need an arraylist where you can save all the existing users, then iterate through the users 0
        //with the arguments provided
    }
}

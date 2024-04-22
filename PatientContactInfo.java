package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import com.example.pediatendprimary.DBHandler.primaryInteractor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static com.example.pediatendprimary.Main.*;

public class PatientContactInfo {

    public PatientContactInfo() {}

    //declare me variables <3
    Label emailLabel = new Label("email:   ");
    TextField email = new TextField("<jeandeaux@aol.com");

    Label phoneLabel = new Label("phone: ");
    TextField phone = new TextField("641-425-6092");

    Label title = new Label("Jean Deaux's contact information");
    Button edit1 = new Button("edit");
    Button edit2 = new Button("edit");
    HBox emailBox = new HBox(5, emailLabel, email, edit1);
    HBox phoneBox = new HBox(5, phoneLabel, phone, edit2);
    VBox contactInfo = new VBox(10, emailBox, phoneBox);
    Button save = new Button("save");
    Button back = new Button("Back");
    HBox bottomButtons = new HBox(10, back, save);
    BorderPane border = new BorderPane();
    Scene PatientContactInfoScene = new Scene(border, 640, 480);
    String emailData;
    String phoneData;
    public static primaryInteractor primaryInteractor = new primaryInteractor();

    public void set() {
        email.setEditable(false);
        phone.setEditable(false);       //false unless select edit button

        border.setTop(title);
        title.setStyle("-fx-font: 16 verdana");
        BorderPane.setAlignment(title, Pos.CENTER);

        border.setPadding(new Insets(30, 20, 20, 20));

        BorderPane.setAlignment(contactInfo, Pos.CENTER);
        emailBox.setAlignment(Pos.CENTER);
        phoneBox.setAlignment(Pos.CENTER);
        border.setCenter(contactInfo);
        contactInfo.setAlignment(Pos.CENTER);

        border.setBottom(bottomButtons);

        edit1.setStyle(BUTTON_STYLE);
        edit2.setStyle(BUTTON_STYLE);
        save.setStyle(BUTTON_STYLE);
        back.setStyle(BUTTON_STYLE);

        edit1.setOnAction(e -> {
            email.setEditable(true);
        });
        edit2.setOnAction(e -> {
            phone.setEditable(true);
        });

        save.setOnAction(e -> {
            email.setEditable(false);
            phone.setEditable(false);
            //primaryInteractor.writeToFileContact(email.getText(),phone);

            //save to database

        });
        back.setOnAction(ActionEvent -> {
            patientHub.set();
        });
        border.setStyle("-fx-background-color: gray;");

        Main.mainStage.setScene(PatientContactInfoScene);
    }

    public void getContactInfo(VBox contactInfo) {
        this.contactInfo = contactInfo; //gets info from the text fields and saves them to patient contact info
        //get info from sign up page if they're a new user or from database if they're existing
    }
}

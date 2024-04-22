package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static com.example.pediatendprimary.Main.*;

public class DoctorHub{

    public DoctorHub(){}
    //Image image = new Image ("../../../../../pediatend.png");
    //ImageView imageView = new ImageView(image);
    Text title = new Text("PediaTend");


    Label authenticated = new Label("You have successfully been authenticated.");
    Button viewMessages = new Button("View Messages");
    Button patientDirButton = new Button("Patient Directory");
    Button signOut = new Button("Sign Out");
    VBox titleBox = new VBox(title, authenticated);
    VBox buttonBox = new VBox(viewMessages, patientDirButton, signOut);
    BorderPane doctorPane = new BorderPane();
    Scene doctorHubScene = new Scene(doctorPane, 640, 480); // 4:3


    public void set() {
        doctorPane.setStyle("-fx-background-color: gray;");
        patientDirButton.setStyle(BUTTON_STYLE);
        viewMessages.setStyle(BUTTON_STYLE);
        signOut.setStyle(BUTTON_STYLE);

        title.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 25));
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setSpacing(10);
        titleBox.setTranslateY(50);

        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);


        doctorPane.setTop(titleBox);
        doctorPane.setCenter(buttonBox);

        mainStage.setScene(doctorHubScene);

        patientDirButton.setOnAction(e-> {      //patient directory button now takes it to directory UI
            patientDirectory.set();
        });
        viewMessages.setOnAction(e-> {      //patient directory button now takes it to directory UI
            doctorMessages.set();
        });
        signOut.setOnAction(e-> {
            loginPage.set();
        });
    }
}

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
public class NurseHub {

    public NurseHub(){}
    //Image image = new Image ("../../../../../pediatend.png");
    //ImageView imageView = new ImageView(image);
    Text title = new Text("PediaTend");


    Label authenticated = new Label("You have successfully been authenticated.");
    Button viewMessages = new Button("View Messages");
    Button patientDirectory = new Button("Patient Directory");
    Button signOut = new Button("Sign Out");
    VBox titleBox = new VBox(title, authenticated);
    VBox buttonBox = new VBox(viewMessages, patientDirectory, signOut);
    BorderPane nursePane = new BorderPane();
    Scene nurseHubScene = new Scene(nursePane, 640, 480); // 4:3

    public static PatientDirectory PatientDirectory = new PatientDirectory();

    public void set() {
        nursePane.setStyle("-fx-background-color: gray;");

        title.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 25));
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setSpacing(10);
        titleBox.setTranslateY(50);

        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);


        nursePane.setTop(titleBox);
        nursePane.setCenter(buttonBox);

        mainStage.setScene(nurseHubScene);

        patientDirectory.setStyle(BUTTON_STYLE);
        signOut.setStyle(BUTTON_STYLE);
        viewMessages.setStyle(BUTTON_STYLE);

        patientDirectory.setOnAction(e-> {
            PatientDirectory.set();
        });

        signOut.setOnAction(e-> {
            loginPage.set();
        });

        viewMessages.setOnAction(e-> {
            nurseMessages.set();
        });
    }
}

package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static com.example.pediatendprimary.Main.*;
public class PatientHub {

    public PatientHub(){}
    //Image image = new Image ("../../../../../pediatend.png");
    //ImageView imageView = new ImageView(image);
    Text title = new Text("PediaTend");


    Label authenticated = new Label("You have successfully been authenticated.");
    Button healthData = new Button("Health Data");
    Button contactProvider = new Button("Contact Provider");
    Button changeContactInfo = new Button("Change Contact Info");
    Button signOut = new Button("Sign Out");
    VBox titleBox = new VBox(title, authenticated);
    VBox buttonBox = new VBox(healthData, contactProvider, changeContactInfo, signOut);
    HBox mainBox = new HBox(buttonBox); //Add the most recent visit to mainBox here
    BorderPane patientPane = new BorderPane();
    Scene patientHubScene = new Scene(patientPane, 640, 480); // 4:3

    // public static PatientContactInfo PatientContactInfo = new PatientContactInfo();
    // ^^^ deleted the above line because the instance is already in main
    // and the instance name should not be capitalized

    /*public void start (Stage primaryStage){   // delete?
        VBox parent = new VBox();
        Image image = new Image ("../../../../../src/pediatend.png");
        ImageView imageView = new ImageView(image);
        parent.getChildren().add(imageView);
        parent.getChildren().add(new Label("You have successfully been authenticated."));
        HBox mainArea = new HBox();
        VBox insideArea = new VBox();
        Button healthData = new Button("Health Data");
        Button contactProvider = new Button("Contact Provider");
        Button changeContactInfo = new Button("Change Contact Info");
        insideArea.getChildren().add(healthData);
        insideArea.getChildren().add(contactProvider);
        insideArea.getChildren().add(changeContactInfo);
        mainArea.getChildren().add(insideArea);
        //Add the most recent visit to mainArea here
        parent.getChildren().add(mainArea);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
*/

    public void set() {
        patientPane.setStyle("-fx-background-color: gray;");
        signOut.setStyle(BUTTON_STYLE);
        contactProvider.setStyle(BUTTON_STYLE);
        healthData.setStyle(BUTTON_STYLE);
        changeContactInfo.setStyle(BUTTON_STYLE);

        title.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 25));
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setSpacing(10);
        titleBox.setTranslateY(50);

        mainBox.setAlignment(Pos.CENTER_LEFT);
        mainBox.setSpacing(10);

        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.setTranslateX(50);
        buttonBox.setSpacing(10);

        patientPane.setTop(titleBox);
        patientPane.setCenter(mainBox);

        mainStage.setScene(patientHubScene);
        changeContactInfo.setOnAction(e-> {
            patientContactInfo.set();
        });


        signOut.setOnAction(e-> {
            loginPage.set();
        });

        contactProvider.setOnAction(e-> {
            patientMessages.set();
        });

        healthData.setOnAction(e-> {
            patientHist.set();
        });

        changeContactInfo.setOnAction(e-> {
            patientContactInfo.set();
        });
    }
}

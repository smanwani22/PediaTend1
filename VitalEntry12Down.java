package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.stash.Patient;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import static com.example.pediatendprimary.Main.*;

import java.util.ArrayList;

public class VitalEntry12Down {

    public VitalEntry12Down() {}

    Text logoTitle = new Text("PediaTend");
    Text pageTitle = new Text("Vitals Entry");
    HBox hbTitle = new HBox(100, logoTitle, pageTitle);

    Label patName = new Label("Patient: Eren Doegar");
    Label patAge = new Label("Age: 8years 4months");
    VBox vbPat = new VBox(10, patName, patAge);

    Label patWeight = new Label("Weight: ");
    TextField tfWeight = new TextField();
    HBox hbWeight = new HBox(10, patWeight,tfWeight);

    Label patHeight = new Label("Height: ");
    TextField tfHeight = new TextField();
    HBox hbHeight = new HBox(10, patHeight,tfHeight);

    Label patTemp = new Label("Temperature (F): ");
    TextField tfTemp = new TextField();
    HBox hbTemp = new HBox(10, patTemp,tfTemp);

    Pane bProceedPane = new Pane();
    Button bProceed = new Button("Proceed");
    Button back = new Button("Back");
    HBox hbProceed = new HBox(10, bProceed, back);

    VBox center = new VBox(10,vbPat,hbWeight,hbHeight,hbTemp,hbProceed);

    BorderPane content = new BorderPane(center, hbTitle, null, null, null);
    Scene loginScene = new Scene(content, 640, 480); // 4:3


    public void set() {

        content.setStyle("-fx-background-color: gray;");
        back.setStyle(BUTTON_STYLE);

        logoTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 25));
        pageTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 25));
        hbTitle.setPadding(new Insets(25, 0, 0, 0));
        hbTitle.setAlignment(Pos.CENTER);
        hbProceed.setAlignment(Pos.BOTTOM_RIGHT);

        center.setAlignment(Pos.CENTER);
        center.setPadding(new Insets(20));
        center.setMaxWidth(400);

        tfWeight.setPrefWidth(275);
        tfHeight.setPrefWidth(278);
        tfTemp.setPrefWidth(202);
        bProceedPane.setPrefWidth(280);

        patName.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
        patAge.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
        patWeight.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
        patHeight.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
        patName.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
        patTemp.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));

        back.setOnAction(e-> {
            nurseHub.set();
        });

        mainStage.setScene(loginScene);
    }

    public void setInfo(ArrayList<Patient> patients, TextField tfWeight, TextField tfHeight, TextField tfTemp){
        double weight = Double.parseDouble(tfWeight.getText());
        int height = Integer.parseInt(tfHeight.getText());
        double temp = Double.parseDouble(tfTemp.getText());
//        Patient.setWeight(weight);
//        Patient.setHeight(height);
//        Patient.setBodyTemp(temp);
    }
}//Vitals need to be saved to a database so that we can access them and display them under visits in patient history
// and in mostrecentvitals class

package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import com.example.pediatendprimary.stash.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

import static com.example.pediatendprimary.Main.*;

public class PatientMessages {

    public PatientMessages() {}

    Label chatTitle = new Label("Your Chats");

    TextField chatField = new TextField();
    TextArea chatArea = new TextArea();

    Button nurse = new Button("Nurse");
    Button doctor = new Button("Doctor");
    Button callNurse = new Button("Call Nurse");
    Button send = new Button("Send");
    Button back = new Button("Back");

    HBox mainBox = new HBox(50, chatTitle, callNurse, back);
    VBox sideChatBox = new VBox(10, nurse, doctor);
//    VBox sideChatBox = new VBox(10);
    HBox miniChatWrapper = new HBox(5, chatField, send);
    VBox mainChatBox = new VBox(10, chatArea, miniChatWrapper);
    HBox chatWrapper = new HBox(20, sideChatBox, mainChatBox);

    VBox mainWrapper = new VBox(20, mainBox, chatWrapper);

    StackPane PatientChatPane = new StackPane(mainWrapper);
    Scene PatientChatScene = new Scene(PatientChatPane, 640, 480); // 4:3

    public void set() {

        chatTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));

        send.setStyle(BUTTON_STYLE);
        back.setStyle(BUTTON_STYLE);

        PatientChatPane.setStyle("-fx-background-color: gray;");
        PatientChatPane.setAlignment(Pos.CENTER);
        PatientChatPane.setPadding(new Insets(125));

        chatArea.setEditable(false);
        chatArea.setMinSize(200, 200);

        miniChatWrapper.setAlignment(Pos.CENTER);

        doctor.setMinSize(75, 30);
        nurse.setMinSize(75, 30);
        callNurse.setMinSize(100, 30);

        chatField.setPromptText("Type your messages here...");
        chatArea.setPromptText("Your messages will show up here...");

        sideChatBox.setStyle("-fx-border-style: solid inside;");

        send.setOnAction((event) -> {
            chatArea.appendText("You: " + chatField.getText() + "\n");
            //User.setMessage();
            chatArea.clear();
        });

        back.setOnAction((event) -> {
            patientHub.set();
        });

        mainStage.setScene(PatientChatScene);
    }

    public void addToList(ArrayList<Patient> patientsList){
        for(int i = 0; i < patientsList.size(); i++){
            Button buttons = new Button(patientsList.get(i).firstName + " " + patientsList.get(i).lastName);
            buttons.setStyle("-fx-background-radius: 15px");
            buttons.setMinSize(75, 30);
            sideChatBox.getChildren().addAll(buttons);
        }
        //adds patients from database to patient directory page
    }

    public void getMessages(String providerFName, String providerLName, String patientFName, String patientLName){
        //User.getMessages;
        //changes the messages on the chat area depending on who you are talking to
    }

    public void setMessages(TextField chatField){
        //User.setMessages(chatField.getText());
    }
}

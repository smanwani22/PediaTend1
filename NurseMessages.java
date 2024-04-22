package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import com.example.pediatendprimary.stash.Patient;
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

public class NurseMessages {

    public NurseMessages() {}

    Label chatTitle = new Label("Your Chats");

    TextField chatField = new TextField();
    TextArea chatArea = new TextArea();

    Button doctor = new Button("Doctor");
    Button patient = new Button("Patient");
    Button send = new Button("Send");
    Button back = new Button("Back");

    HBox mainBox = new HBox(50, chatTitle, back);
    VBox sideChatBox = new VBox(10, doctor, patient);
    HBox miniChatWrapper = new HBox(5, chatField, send);
    VBox mainChatBox = new VBox(10, chatArea, miniChatWrapper);
    HBox chatWrapper = new HBox(20, sideChatBox, mainChatBox);

    VBox mainWrapper = new VBox(20, mainBox, chatWrapper);

    StackPane NurseChatPane = new StackPane(mainWrapper);
    Scene NurseChatScene = new Scene(NurseChatPane, 640, 480); // 4:3

    public void set() {

        chatTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));

        NurseChatPane.setStyle("-fx-background-color: gray;");
        NurseChatPane.setAlignment(Pos.CENTER);
        NurseChatPane.setPadding(new Insets(125));

        chatArea.setEditable(false);
        chatArea.setMinSize(200, 200);

        miniChatWrapper.setAlignment(Pos.CENTER);

        patient.setMinSize(75, 30);
        doctor.setMinSize(75, 30);

        chatField.setPromptText("Type your messages here...");
        chatArea.setPromptText("Your messages will show up here...");

        sideChatBox.setStyle("-fx-border-style: solid inside;");

        send.setStyle(BUTTON_STYLE);
        back.setStyle(BUTTON_STYLE);

        send.setOnAction((event) -> {
            chatArea.appendText("You: " + chatField.getText() + "\n");
            chatField.clear();
        });

        back.setOnAction((event) -> {
            nurseHub.set();
        });

        mainStage.setScene(NurseChatScene);
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

    public void getMessages(String providerFName, String providerLName, String patientFName, String patientLName) {
        //User.getMessages;
        //changes the messages on the chat area depending on who you are talking to
        // need database to get chat history.  Then can implement the retrieveNurseMessages
        // and retrievePatientMessages methods
    }
    /*
    public void getMessages(String providerFName, String providerLName, String patientFName, String patientLName) {
    // Clear the chatArea before displaying new messages
    chatArea.clear();

    if (providerFName.equals("Doctor")) {
        // Retrieve messages with the doctor and display them
        String doctorMessages = retrieveDoctorMessages(providerFName, providerLName, patientFName, patientLName);
        chatArea.appendText(doctorMessages);
    } else if (providerFName.equals("Patient")) {
        // Retrieve messages with the patient and display them
        String patientMessages = retrievePatientMessages(providerFName, providerLName, patientFName, patientLName);
        chatArea.appendText(patientMessages);
    }
}
     */
}

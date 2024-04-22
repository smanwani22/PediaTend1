package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.stash.Message;
import com.example.pediatendprimary.stash.Patient;
import com.example.pediatendprimary.stash.User;
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

public class DoctorMessages {
    private ArrayList<Message> messages = new ArrayList<>();


    public DoctorMessages() {}

    Label chatTitle = new Label("Your Chats");

    TextField chatField = new TextField();
    TextArea chatArea = new TextArea();

    Button nurse = new Button("Nurse");
    Button patient = new Button("Patient");
    Button send = new Button("Send");
    Button back = new Button("Back");

    HBox mainBox = new HBox(50, chatTitle, back);
    VBox sideChatBox = new VBox(10, nurse, patient);
    HBox miniChatWrapper = new HBox(5, chatField, send);
    VBox mainChatBox = new VBox(10, chatArea, miniChatWrapper);
    HBox chatWrapper = new HBox(20, sideChatBox, mainChatBox);

    VBox mainWrapper = new VBox(20, mainBox, chatWrapper);

    StackPane DoctorChatPane = new StackPane(mainWrapper);
    Scene DoctorChatScene = new Scene(DoctorChatPane, 640, 480); // 4:3

    public void set() {
        chatTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));

        send.setStyle(BUTTON_STYLE);
        back.setStyle(BUTTON_STYLE);

        DoctorChatPane.setStyle("-fx-background-color: gray;");
        DoctorChatPane.setAlignment(Pos.CENTER);
        DoctorChatPane.setPadding(new Insets(125));

        chatArea.setEditable(false);
        chatArea.setMinSize(200, 200);

//        ArrayList<Patient> testArrayList;
//        addToList(testArrayList);

        miniChatWrapper.setAlignment(Pos.CENTER);

        patient.setMinSize(75, 30);
        nurse.setMinSize(75, 30);

        chatField.setPromptText("Type your messages here...");
        chatArea.setPromptText("Your messages will show up here...");

        sideChatBox.setStyle("-fx-border-style: solid inside;");


        send.setOnAction((event) -> {
            String content = chatField.getText();
            User currentUser = new User("Your First Name", "Your Last Name", "Your Email", "Your Password", User.UserType.DOCTOR);
            Message message = new Message(currentUser, content);
            messages.add(message);

            chatArea.appendText("You: " + chatField.getText() + "\n");
            chatField.clear();
            //write messages function ... search for 'Messages:' then rewrite everytime send clicked

        });

        back.setOnAction((event) -> {

            doctorHub.set();
        });

        mainStage.setScene(DoctorChatScene);
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
        chatArea.clear();
        for (Message message : messages) {
            if (message.getFrom().getFirstName().equals(providerFName) &&
                    message.getFrom().getLastName().equals(providerLName)) {
                chatArea.appendText("Nurse: " + message.getContent() + "\n");
            } else if (message.getFrom().getFirstName().equals(patientFName) &&
                    message.getFrom().getLastName().equals(patientLName)) {
                chatArea.appendText("Patient: " + message.getContent() + "\n");
            }
        }
        //chatArea.appendText(User.getMessages());
        //changes the messages on the chat area depending on who you are talking to
        // need database to get chat history.  Then can implement the retrieveNurseMessages
        // and retrievePatientMessages methods
    }
    /*
    public void getMessages(String providerFName, String providerLName, String patientFName, String patientLName) {
    // Clear the chatArea before displaying new messages
    chatArea.clear();

    if (providerFName.equals("Nurse")) {
        // Retrieve messages with the nurse and display them
        String nurseMessages = retrieveNurseMessages(providerFName, providerLName, patientFName, patientLName);
        chatArea.appendText(nurseMessages);
    } else if (providerFName.equals("Patient")) {
        // Retrieve messages with the patient and display them
        String patientMessages = retrievePatientMessages(providerFName, providerLName, patientFName, patientLName);
        chatArea.appendText(patientMessages);
    }
}
     */

}

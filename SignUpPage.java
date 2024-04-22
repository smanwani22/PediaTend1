package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.DBHandler.primaryInteractor;
import com.example.pediatendprimary.stash.Patient;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import static com.example.pediatendprimary.Main.*;

public class SignUpPage {

    public SignUpPage() {}
    public static String firstName;
    public static String lastName;
    public static int dob;


    Text title = new Text("PediaTend");

    Label fNameLabel = new Label("First Name: ");
    Label lNameLabel = new Label("Last Name: ");
    Label bDateLabel = new Label("Birth Date: ");
    Label emailLabel = new Label("Email: ");
    Label pwdLabel = new Label("Password: ");
    Label repeatPwdLabel = new Label("Repeat Password: ");

    TextField fNameField = new TextField();
    TextField lNameField = new TextField();
    TextField dayField = new TextField();
    TextField monthField = new TextField();
    TextField yearField = new TextField();
    TextField emailField = new TextField();
    PasswordField pwdField = new PasswordField();
    PasswordField repeatPwdField = new PasswordField();

    Button back = new Button("Back");
    Button confirmPatient = new Button("Sign Up Patient");


    HBox titleBox = new HBox(title);
    HBox fNameBox = new HBox(fNameLabel, fNameField);
    HBox lNameBox = new HBox(lNameLabel, lNameField);
    HBox bDateBox = new HBox(8, bDateLabel, monthField, dayField, yearField);
    HBox emailBox = new HBox(emailLabel, emailField);
    HBox pwdBox = new HBox(pwdLabel, pwdField);
    HBox repeatPwdBox = new HBox(repeatPwdLabel, repeatPwdField);
    HBox buttonsBox = new HBox(50, back, confirmPatient);

    VBox signUpBox = new VBox(fNameBox, lNameBox, bDateBox, emailBox, pwdBox, repeatPwdBox);
    BorderPane signUpPane = new BorderPane(signUpBox, titleBox, null, buttonsBox, null);
    Scene signUpScene = new Scene(signUpPane, 640, 480);

    primaryInteractor primaryInteractor = new primaryInteractor();

    public void set() {
        signUpPane.setStyle("-fx-background-color: gray;");
        back.setStyle(BUTTON_STYLE);
        confirmPatient.setStyle(BUTTON_STYLE);

        fNameBox.setAlignment(Pos.CENTER);
        lNameBox.setAlignment(Pos.CENTER);

        emailField.setPromptText("user@example.com");
        pwdField.setPromptText("........");
        monthField.setPromptText("MM");
        dayField.setPromptText("DD");
        yearField.setPromptText("YYYY");

        monthField.setMaxWidth(50);
        dayField.setMaxWidth(50);
        yearField.setMaxWidth(50);

        bDateBox.setAlignment(Pos.CENTER);

        title.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 25));
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(25, 0, 0, 0));

        signUpBox.setAlignment(Pos.CENTER);
        signUpBox.setSpacing(10);

        emailField.setPrefSize(200, 25);
        emailBox.setAlignment(Pos.CENTER);
        emailBox.setSpacing(5);
        pwdBox.setAlignment(Pos.CENTER);
        repeatPwdBox.setAlignment(Pos.CENTER);

        back.setPrefSize(75, 25);
        confirmPatient.setPrefSize(125, 25);

        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setPadding(new Insets(0, 0, 75, 0));

        back.setOnAction(actionEvent -> {
            loginPage.set();
        });

        confirmPatient.setOnAction((event) -> {

            // gets the field
            firstName = fNameField.getText();
            lastName = lNameField.getText();
            dob = Integer.parseInt(monthField.getText() + dayField.getText() + yearField.getText());
            //initialize patient with file data!
            try {
                primaryInteractor.writeToFile(firstName, lastName, dob, emailField.getText(), pwdField.getText());
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e);
            }

            if(pwdField.getText().equals(repeatPwdField.getText())){
                //setInfo(patients, fNameField, lNameField, dayField, monthField, yearField, emailField, pwdField);
                /*try {
                    primaryInteractor.readFile(firstName,lastName,dob);
                } catch (NoSuchAlgorithmException | FileNotFoundException e) {
                    throw new RuntimeException(e);
                }*/
            }
            patientHub.set();
        });

        mainStage.setScene(signUpScene);
    }

    public void setInfo(ArrayList<Patient> patients, TextField fNameField, TextField lNameField, TextField dayField, TextField monthField, TextField yearField, TextField emailField, PasswordField pwdField){
        String fName = fNameField.getText();
        String lName = lNameField.getText();
        String email = emailField.getText();
        String pwd = pwdField.getText();
        String day = dayField.getText();
        String month = monthField.getText();
        String year = yearField.getText();
        new Patient(fName, lName, year, month, day,email,pwd);
        //return patient to arrayList of patients
    }

    //private void primaryInteractor(String text, String text1, int i, String text2, String text3) {
}
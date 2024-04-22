package com.example.pediatendprimary.pages;

import com.example.pediatendprimary.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Objects;

import static com.example.pediatendprimary.Main.*;

public class LoginPage {


    public LoginPage() {
    }

    Text title = new Text("PediaTend");

    Label emailLabel = new Label("Email: ");
    Label pwdLabel = new Label("Password: ");

    TextField emailField = new TextField();

    Button signUp = new Button("Sign Up");
    Button loginPatient = new Button("Log In Patient");
    Button loginNurse = new Button("Log In Nurse");
    Button loginDoctor = new Button("Log In Doctor");


    Hyperlink forgotPwd = new Hyperlink("Forgot Password?");

    PasswordField pwdField = new PasswordField();

    HBox titleBox = new HBox(title);
    HBox emailBox = new HBox(emailLabel, emailField);
    HBox pwdBox = new HBox(pwdLabel, pwdField);

    HBox loginButtons = new HBox(10, loginPatient, loginNurse, loginDoctor, signUp);
    VBox loginBox = new VBox(emailBox, pwdBox, loginButtons, forgotPwd);
    BorderPane loginPane = new BorderPane(loginBox, titleBox, null, null, null);
    Scene loginScene = new Scene(loginPane, 640, 480); // 4:3

    public void set() {


        loginPane.setStyle("-fx-background-color: gray;");
        signUp.setStyle(BUTTON_STYLE);
        loginNurse.setStyle(BUTTON_STYLE);
        loginDoctor.setStyle(BUTTON_STYLE);
        loginPatient.setStyle(BUTTON_STYLE);

        title.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 25));
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(25, 0, 0, 0));

        loginBox.setAlignment(Pos.CENTER);
        loginBox.setSpacing(10);

        emailField.setPromptText("user@example.com");
        pwdField.setPromptText("........");
        emailField.setPrefSize(200, 25);
        emailBox.setAlignment(Pos.CENTER);
        emailBox.setSpacing(5);
        pwdBox.setAlignment(Pos.CENTER);
        loginButtons.setAlignment(Pos.CENTER);

        loginNurse.setPrefSize(100, 25);
        loginDoctor.setPrefSize(100, 25);
        loginPatient.setPrefSize(100, 25);


        signUp.setOnAction((event) -> {
            signUpPage.set();
        });

        loginNurse.setOnAction((event) -> {
            nurseHub.set();
        });

        loginPatient.setOnAction((event) -> {
            patientHub.set();
        });

        loginDoctor.setOnAction((event) -> {
            doctorHub.set();
        });

        mainStage.setScene(loginScene);
    }

}

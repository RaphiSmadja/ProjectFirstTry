package com.example.wallet.controller;

import com.example.wallet.HelloApplication;
import com.example.wallet.services.GestionUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.regex.Pattern;

import static com.example.wallet.HelloApplication.stage;


public class InscriptionController {
    @FXML
    public Label descriptionLabel;

    @FXML
    public TextField nameField;

    @FXML
    public TextField firstNameField;

    @FXML
    public TextField birthdayField;

    @FXML
    public TextField mailField;

    @FXML
    public TextField passwordField;


    @FXML
    public void onReturnButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768); // standard de base
        stage.setScene(scene);
        stage.show();
    }

    public void onInscriptionButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("connexion-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        descriptionLabel.setText("Successful registration !");
        GestionUser gestion = new GestionUser();
        if(isValidEmail(mailField.getText())){
            gestion.inscrireUtilisateur(mailField.getText(),passwordField.getText(), nameField.getText(),firstNameField.getText(), birthdayField.getText());
        }
        else {
            descriptionLabel.setText("Please try again! The format of your e-mail address is incorrect.");
        }
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pattern.matcher(email).matches();
    }
}



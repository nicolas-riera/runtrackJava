package javafx.runtrack;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button quitButton;

    @FXML
    private Button sendButton;

    @FXML
    private TextField nomInput;

    @FXML
    private MenuItem redButton;
    @FXML
    private MenuItem blueButton;
    @FXML
    private MenuItem greenButton;

    @FXML
    private void handleQuitAction() {   
        Platform.exit(); 
    }

    @FXML
    private void handleSendAction() {
        String valeur = nomInput.getText();
        System.out.println(valeur);
    }

    @FXML
    private void handleRedButton() {
        System.out.println("Red");
    }
    @FXML
    private void handleBlueButton() {
        System.out.println("Blue");
    }
    @FXML
    private void handleGreenButton() {
        System.out.println("Green");
    }
} 
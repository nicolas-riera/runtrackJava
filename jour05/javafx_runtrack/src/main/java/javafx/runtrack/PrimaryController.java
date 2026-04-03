package javafx.runtrack;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button quitButton;

    @FXML
    private Button sendButton;

    @FXML
    private TextField nomInput;

    @FXML
    private ChoiceBox<String> colorPicker1;
    @FXML
    private ChoiceBox<String> colorPicker2;
    @FXML
    private Button okColorButton;

    @FXML
    public void initialize() {
        
        colorPicker1.getItems().addAll("Rouge", "Bleu", "Vert");
        colorPicker1.getSelectionModel().selectFirst();

        colorPicker2.getItems().addAll("Rose", "Cyan", "Jaune");
        colorPicker2.getSelectionModel().selectFirst();
    }

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
    private void handleColorButton() {   
       String color1 = colorPicker1.getValue();
       String color2 = colorPicker2.getValue();
       System.out.println(color1);
       System.out.println(color2);
    }
} 
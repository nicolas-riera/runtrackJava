package javafx.runtrack;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button quitButton;

    @FXML
    private void handleQuitAction() {
        Platform.exit(); 
    }
} 
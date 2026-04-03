package javafx.runtrack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX Application
 */
public class App extends Application 
{
    @Override
    public void start(Stage stage) 
    {
        Label label = new Label("Hello Nic");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 800, 800);
        
        stage.setTitle("JavaFX RunTrack");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}

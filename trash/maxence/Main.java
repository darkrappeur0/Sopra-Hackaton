import affichage.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Charger la première scène en démarrant l'application
        Scene firstScene = FirstScene.getScene(primaryStage);

        // Configurer la fenêtre principale avec la première scène
        primaryStage.setTitle("Changement de scènes avec plusieurs fichiers");
        primaryStage.setScene(firstScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

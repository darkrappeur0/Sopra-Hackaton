package affichage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.event.*;







public class FirstScene {

    public static Scene getScene(Stage primaryStage) {
        // Créer un bouton pour passer à la deuxième scène
        Button but1 = new Button("Administrateur");

        Button but2 = new Button("Civile");
        // Créer un layout pour la première scène
        
        
        VBox layout = new VBox(10);  // 10 est l'espacement entre les boutons
        layout.setPadding(new Insets(20));  // Ajouter des marges autour du VBox
        layout.setAlignment(Pos.CENTER);  // Centrer les boutons dans la scène

        layout.setStyle("-fx-background-color: royalblue;");

        layout.getChildren().addAll(but1,but2); 

        // Créer la scène
        Scene firstScene = new Scene(layout, 300, 200);

        // Gérer l'action du bouton pour charger la deuxième scène
        but1.setOnAction(e -> {
            Scene secondScene = SecondScene.getScene(primaryStage);
            primaryStage.setScene(secondScene);  // Changer de scène
        });
        but2.setOnAction(e -> {
            Scene thirdScene = ThirdScene.getScene(primaryStage);
            primaryStage.setScene(thirdScene);  // Changer de scène
        });
        return firstScene;
    }
}

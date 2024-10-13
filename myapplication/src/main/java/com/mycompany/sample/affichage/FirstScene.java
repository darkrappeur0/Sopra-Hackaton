package com.mycompany.sample.affichage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.scene.layout.*;
import javafx.geometry.*;







public class FirstScene {

    public static Scene getScene(Stage primaryStage) {

        // Création des boutons pour l'affichage
        Button but1 = new Button("Administrateur");

        Button but2 = new Button("Civile");

        // Créer un layout pour la première scène
        
        
        VBox layout = new VBox(10);  
        layout.setPadding(new Insets(20));  // Ajouter des marges autour du VBox
        layout.setAlignment(Pos.CENTER);  // Centrer les boutons dans la scène

        layout.setStyle("-fx-background-color: royalblue;");

        layout.getChildren().addAll(but1,but2); 

        // création de la scène
        Scene firstScene = new Scene(layout, 300, 200);

        // Action des boutons
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

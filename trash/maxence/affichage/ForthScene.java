package affichage;


import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ForthScene{
    public static Scene getScene(Stage primaryStage) {
        // Créer un bouton pour passer à la deuxième scène
        Button but1 = new Button("Maps");
        Button but2 = new Button("Assistance-Messagerie");
        Button but3 = new Button("Compte");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        // Créer un layout pour la première scène
        
        
        

        grid.add(but1, 5, 5);
        grid.add(but2, 30, 65);
        grid.add(but3, 25, 0);
        

        grid.setStyle("-fx-background-color: royalblue;");


        // Créer la scène
        Scene forthScene = new Scene(grid, 400, 750);

        but1.setOnAction(e -> {
            Scene secondScene = SecondScene.getScene(primaryStage);
            primaryStage.setScene(secondScene);  // Changer de scène
        });
        but2.setOnAction(e -> {
            Scene assismesScene = AssisMes.getScene(primaryStage);
            primaryStage.setScene(assismesScene);  // Changer de scène
        }); 
        but3.setOnAction(e -> {
            Scene aaaaa = AffCompte.getScene(primaryStage);
            primaryStage.setScene(aaaaa);  // Changer de scène
        });
        
        
        return forthScene;
    }
}
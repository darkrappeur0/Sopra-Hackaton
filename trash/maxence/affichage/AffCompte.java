package affichage;


import affichage.classprojet.*;
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
import jdk.jshell.execution.Util;


public class AffCompte{
    public static Scene getScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Compte c = new Compte("test","test","user");

        // Ajouter les champs de texte et les étiquettes pour le formulaire
        
        Label nom = new Label("Nom : " + c.getNom());
        
        Label prenom = new Label("Prénom :" + c.getPrenom());
       
        Label pseudo = new Label("Pseudo : " + c.getPseudo() );
        
        // Bouton pour se connecter
        Button retour = new Button("Retour");

        // Ajouter les éléments à la grille
 
        grid.add(nom, 0, 0);
        grid.add(prenom, 0, 1);
        grid.add(pseudo, 0, 2);
        grid.add(retour, 0, 3);



        // Gérer l'action du bouton de connexion (vous pouvez ajouter de la logique de validation ici)
        retour.setOnAction(e -> {
            Scene forthScene = ForthScene.getScene(primaryStage);
            primaryStage.setScene(forthScene);  // Changer de scène
            
        });
        Scene Affcompte = new Scene(grid, 400, 750);

        return Affcompte;
    }
    
}
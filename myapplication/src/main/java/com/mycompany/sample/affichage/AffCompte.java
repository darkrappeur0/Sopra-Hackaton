package com.mycompany.sample.affichage;


import com.mycompany.sample.affichage.classprojet.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class AffCompte{
    public static Scene getScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Compte c = new Compte("test","test","user");

        // création des champs a afficher
        
        Label nom = new Label("Nom : " + c.getNom());
        
        Label prenom = new Label("Prénom :" + c.getPrenom());
       
        Label pseudo = new Label("Pseudo : " + c.getPseudo() );
        
        // Bouton pour retourner a la page précédente
        Button retour = new Button("Retour");

        // Ajouter les éléments à la grille
 
        grid.add(nom, 0, 0);
        grid.add(prenom, 0, 1);
        grid.add(pseudo, 0, 2);
        grid.add(retour, 0, 3);



        // Action des boutons
        retour.setOnAction(e -> {
            Scene forthScene = affichmap.getScene(primaryStage);
            primaryStage.setScene(forthScene);  // Changement de scène
            
        });
        Scene Affcompte = new Scene(grid, 400, 750);

        return Affcompte;
    }
    
}
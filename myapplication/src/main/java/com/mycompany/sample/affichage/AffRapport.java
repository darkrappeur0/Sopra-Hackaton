package com.mycompany.sample.affichage;


import com.mycompany.sample.affichage.classprojet.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class AffRapport{
    public static Scene getScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Rapport R = new Rapport();

        // création des champs a afficher
        
        
        Label date = new Label("Date : " + R.getDate());
        
        Label heure = new Label("Heure :" + R.getHeure());
       
        Label lieu = new Label("Lieu : " + R.getLieu() );

        Label motif = new Label("Motif : " + R.getMotif() );
        
        // Bouton pour retourner a la page précédente
        Button retour = new Button("Retour");

        // Ajouter les éléments à la grille
 
        grid.add(date, 0, 0);
        grid.add(heure, 0, 1);
        grid.add(lieu, 0, 2);
        grid.add(motif, 0, 3);
        grid.add(retour, 0, 4);



        // Action des boutons
        retour.setOnAction(e -> {
            Scene forthScene = affadminmap.getScene(primaryStage);
            primaryStage.setScene(forthScene);  // Changement de scène
            
        });
        Scene Affrapport = new Scene(grid, 1000, 800);

        return Affrapport;
    }
    
}
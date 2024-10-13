package com.mycompany.sample.affichage;


import com.mycompany.sample.affichage.classprojet.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class AffadminCompte{
    public static Scene getScene(Stage primaryStage,String name, String username, String firstname) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Compte c = new Compte(firstname,name,username);

        c.setNom(name);
        c.setPrenom(firstname);
        c.setPseudo(username);

        // création des champs a afficher
        
        Label nom1 = new Label("Nom : " + c.getNom());
        
        Label prenom1 = new Label("Prénom :" + c.getPrenom());
       
        Label pseudo1 = new Label("Pseudo : " + c.getPseudo() );
        
        // Bouton pour retourner a la page précédente
        Button retour = new Button("Retour");
        Button modifier = new Button("Modifier");

        // Ajouter les éléments à la grille
 
        grid.add(nom1, 0, 0);
        grid.add(prenom1, 0, 1);
        grid.add(pseudo1, 0, 2);
        grid.add(retour, 0, 3);


        Label nom2 = new Label("Nom : ");
        TextField nomField = new TextField();
        Label prenom2 = new Label("Prénom :" );
        TextField prenomField = new TextField();
        Label pseudo2 = new Label("Pseudo : " );
        TextField pseudoField = new TextField();

        grid.add(nom2, 0, 4);
        grid.add(nomField, 0, 5);
        grid.add(prenom2, 0, 6);
        grid.add(prenomField, 0, 7);
        grid.add(pseudo2, 0, 8);
        grid.add(pseudoField, 0, 9);
        grid.add(modifier, 0, 10);



        // Action des boutons
        retour.setOnAction(e -> {
            Scene forthScene = affadminmap.getScene(primaryStage);
            primaryStage.setScene(forthScene);  // Changement de scène
            
        });
        modifier.setOnAction(e -> {
            String nom3 = nomField.getText();
            String prenom3 = prenomField.getText();
            String pseudo3 = pseudoField.getText();
            Scene reacScene = AffadminCompte.getScene(primaryStage,nom3,pseudo3,prenom3);
            primaryStage.setScene(reacScene);  // Changement de scène
        });
        


        Scene Affcompte = new Scene(grid, 400, 750);

        return Affcompte;
    }
    
}
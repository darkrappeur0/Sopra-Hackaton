package com.mycompany.sample.affichage;



import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ThirdScene {

    public static Scene getScene(Stage primaryStage) {
        // Créer un GridPane pour organiser le formulaire de connexion
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Ajouter les champs de texte et les étiquettes pour le formulaire
        Label userLabel = new Label("Nom d'utilisateur :");
        TextField userField = new TextField();
        
        Label passLabel = new Label("Mot de passe :");
        PasswordField passField = new PasswordField();

        // Bouton pour se connecter
        Button loginButton = new Button("Se connecter");
        Button retour = new Button("Retour");

        // Ajouter les éléments à la grille
        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(retour, 1, 3);

        // Gérer l'action du bouton de connexion (vous pouvez ajouter de la logique de validation ici)
        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            // Traitement de la connection
            if (username.equals("user") && password.equals("4444")) {
                
                Scene forthScene = affichmap.getScene(primaryStage);
                primaryStage.setScene(forthScene);  // Changement de scène
                
            } else {
                System.out.println("Échec de la connexion. Essayez encore.");
            }
        });
        retour.setOnAction(e -> {
            Scene retour1 = FirstScene.getScene(primaryStage);
            primaryStage.setScene(retour1);  // Changer de scène
        });

        // Créer la scène
        Scene loginScene = new Scene(grid, 300, 200);

        return loginScene;
    }
}
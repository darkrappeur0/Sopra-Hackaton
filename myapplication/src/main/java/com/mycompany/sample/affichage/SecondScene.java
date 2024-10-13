package com.mycompany.sample.affichage;




import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SecondScene {

    public static Scene getScene(Stage primaryStage) {
        // Création du gridpane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Champ de connextion
        Label userLabel = new Label("Nom d'utilisateur :");
        TextField userField = new TextField();
        
        Label passLabel = new Label("Mot de passe :");
        PasswordField passField = new PasswordField();

        // Bouton pour se connecter
        Button loginButton = new Button("Se connecter");

        // Ajouter les éléments à la grille
        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginButton, 1, 2);

        // Gestion des action des boutons
        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            // traitement de la connection
            if (username.equals("admin") && password.equals("4444")) {
                Scene fifthScene = affadminmap.getScene(primaryStage);
                primaryStage.setScene(fifthScene);  // Changement de scène
                
                
            } else {
                System.out.println("Échec de la connexion. Essayez encore.");
            }
        });

        // Création et renvoie de la scène
        Scene loginScene = new Scene(grid, 300, 200);
        return loginScene;
    }
}
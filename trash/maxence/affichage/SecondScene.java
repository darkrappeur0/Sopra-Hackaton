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

public class SecondScene {

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

        // Ajouter les éléments à la grille
        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginButton, 1, 2);

        // Gérer l'action du bouton de connexion (vous pouvez ajouter de la logique de validation ici)
        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            // Exemple simple de traitement de connexion (vérifier si les champs sont remplis)
            if (username.equals("admin") && password.equals("4444")) {
                System.out.println("Connexion réussie !");
                
                
            } else {
                System.out.println("Échec de la connexion. Essayez encore.");
            }
        });

        // Créer la scène
        Scene loginScene = new Scene(grid, 300, 200);

        return loginScene;
    }
}
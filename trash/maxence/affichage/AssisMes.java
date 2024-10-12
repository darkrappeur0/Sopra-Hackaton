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


public class AssisMes{
    public static Scene getScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Ajouter les champs de texte et les étiquettes pour le formulaire
        Label label = new Label("Mettez votre message de signalement");
        Label date1 = new Label("Date");
        TextField date2 = new TextField();
        Label heure1 = new Label("Heure");
        TextField heure2 = new TextField();
        Label lieu1 = new Label("Lieu");
        TextField lieu2 = new TextField();
        Label motif1 = new Label("Motif");
        TextField motif2 = new TextField();
        Button retour = new Button("Retour");

        // Bouton pour se connecter
        Button envoyer = new Button("Envoyer");

        // Ajouter les éléments à la grille
        grid.add(label, 0, 0);
        grid.add(date1, 0, 1);
        grid.add(date2, 0, 2);
        grid.add(heure1, 0, 3);
        grid.add(heure2, 0, 4);
        grid.add(lieu1, 0, 5);
        grid.add(lieu2, 0, 6);
        grid.add(motif1, 0, 7);
        grid.add(motif2, 0, 8);
        grid.add(envoyer, 1, 9);
        grid.add(retour, 4, 17);


        // Gérer l'action du bouton de connexion (vous pouvez ajouter de la logique de validation ici)
        envoyer.setOnAction(e -> {
            
            System.out.println("Le message a été envoyer");
        });
        retour.setOnAction(e -> {
            Scene forthScene = ForthScene.getScene(primaryStage);
            primaryStage.setScene(forthScene);  // Changer de scène
            
        });

        Scene AssMes = new Scene(grid, 400, 750);

        return AssMes;
    }
    
}
package support;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;



public class MainView extends VBox{

    public MainView(double spacing){
        super(spacing);

        ObservableList component = this.getChildren();
        
        Button but1 = new Button("Administrateur");
        Button but2 = new Button("Utilisateur");
        but1.setDefaultButton(true);
        but2.setDefaultButton(true);
        component.addAll(but1,but2);
        
    }
    public void affichage_admin(){

        Label someLabel1 = new Label("Nom de compte");
        TextField someTextField1 = new TextField();
        Label someLabel2 = new Label("Mot de passe");
        PasswordField password = new PasswordField();
        Separator sep = new Separator(Orientation.HORIZONTAL);
    }
    
}

package support;



import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;



public class MainView extends VBox{

    public MainView(double spacing){
        super(spacing);
        ObservableList component = this.getChildren();
        Label someLabel1 = new Label("Nom de compte");
        TextField someTextField1 = new TextField();
        Label someLabel2 = new Label("Mdp");
        TextField someTextField2 = new TextField();
        
        component.addAll(someLabel1,someTextField1,someLabel2,someTextField2);
        
    }
    
}

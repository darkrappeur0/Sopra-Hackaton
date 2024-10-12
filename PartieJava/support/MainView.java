package support;

import java.awt.TextField;
import javax.imageio.plugins.tiff.TIFFDirectory;

import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;



public class MainView extends VBox{

    public MainView(double spacing){
        super(spacing);
        ObservableList components = this.getChildren();
        Label someLabel = new Label("ntm");
        TextField someTextField = new TextField();
        components.addAll(someLabel,someTextField);
    }
    
}

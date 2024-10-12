import support.*;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;

public class Interface extends Application{

    private final String WINDOW_TITLE  = "AppliLampadaires" ; 
    private final int WINDOW_WIDTH  = 640 ; 
    private final int WINDOW_HEIGHT  = 480 ; 
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Color b1 = Color.BLUE;
        Scene mainViewScene = new Scene(new MainView(20));
        primaryStage.setScene(mainViewScene);
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
    public static void main(String argv[]){
        launch(argv);
    }
}
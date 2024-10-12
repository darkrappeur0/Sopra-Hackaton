package Interfaceview;

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
        /* Color b1 = Color.BLUE;
        Color b2 = Color.WHITE;
        Scene sc1 = new Scene(new Group(),1280.0,720.0, b1);
        Scene sc2 = new Scene(new Group(),1280.0,520.0, b2);
        primaryStage.setScene(sc1);
        primaryStage.setTitle("Mon premier programme"); */

        Scene mainViewScene = new Scene(new MainView(20));
        primaryStage.setScene(mainViewScene);
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.show();
    }
    public static void main(String argv[]){
        launch(argv);
    }
}
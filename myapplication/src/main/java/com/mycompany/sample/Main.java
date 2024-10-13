package com.mycompany.sample;

import com.mycompany.sample.affichage.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


import com.gluonhq.attach.display.DisplayService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Pair;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Charger la première scène en démarrant l'application
        Scene firstScene = FirstScene.getScene(primaryStage);

        // Configurer la fenêtre principale avec la première scène
        primaryStage.setTitle("Changement de scènes avec plusieurs fichiers");
        primaryStage.setScene(firstScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

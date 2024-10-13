package com.mycompany.sample;

import com.gluonhq.attach.display.DisplayService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Pair;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW;

public class Main extends Application {

    // private final AppManager appManager = AppManager.initialize(this::postInit);

    // @Override
    // public void init() {
    //     appManager.addViewFactory(HOME_VIEW, () -> {
    //         FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.SEARCH.text,
    //                 e -> System.out.println("Search"));

    //         ImageView imageView = new ImageView(new Image(Main.class.getResourceAsStream("openduke.png")));
    //         imageView.setFitHeight(200);
    //         imageView.setPreserveRatio(true);

    //         Label label = new Label("Hello, My Gluon Application!");

    //         VBox root = new VBox(20, imageView, label);
    //         root.setAlignment(Pos.CENTER);

    //         View view = new View(root) {
    //             @Override
    //             protected void updateAppBar(AppBar appBar) {
    //                 appBar.setTitleText("My Gluon Application");
    //             }
    //         };

    //         fab.showOn(view);

    //         return view;
    //     });
    // }

    // @Override
    // public void start(Stage stage) {
    //     appManager.start(stage);
    // }

    // private void postInit(Scene scene) {
    //     Swatch.LIGHT_GREEN.assignTo(scene);
    //     scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
    //     ((Stage) scene.getWindow()).getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));

    //     if (Platform.isDesktop()) {
    //         Dimension2D dimension2D = DisplayService.create()
    //                 .map(DisplayService::getDefaultDimensions)
    //                 .orElse(new Dimension2D(640, 480));
    //         scene.getWindow().setWidth(dimension2D.getWidth());
    //         scene.getWindow().setHeight(dimension2D.getHeight());
    //     }
    // }

    // public static void main(String[] args) {
    //     launch(args);
    // }

    public class LampadaireLayer extends MapLayer {

        private final List<MapPoint> lampadairePoints;
        private final Image lampadaireIcon;
    
        public LampadaireLayer(List<MapPoint> lampadairePoints) {
            this.lampadairePoints = lampadairePoints;
            this.lampadaireIcon = new Image("file:lampadaire.png"); // Icône de lampadaire
        }
    
        @Override
        protected void layoutLayer() {
            getChildren().clear(); // Nettoie les marqueurs précédents
    
            for (MapPoint point : lampadairePoints) {
                Node icon = new ImageView(lampadaireIcon);
                Point2D mapPoint = baseMap.getMapPoint(point.getLatitude(), point.getLongitude());
    
                if (mapPoint != null) {
                    icon.setTranslateX(mapPoint.getX());
                    icon.setTranslateY(mapPoint.getY());
                    getChildren().add(icon); // Ajoute l'icône sur la carte
                }
            }
        }
    }



    @Override
    public void start(Stage primaryStage) {
        // Créer une vue de carte
        MapView mapView = new MapView();

        List<MapPoint> lampadaires = Arrays.asList(
            new MapPoint(45.777222, 3.087025),  // Place de Jaude
            new MapPoint(45.779235, 3.082567),  // Rue Blatin
            new MapPoint(45.780819, 3.087329)   // Avenue Julien
            // Ajoutez d'autres points selon vos besoins
        );

        // Centrer la carte sur Place Jaude à Clermont-Ferrand
        double latitude = 45.774162;
        double longitude = 3.082231;
        MapPoint placeJaude = new MapPoint(latitude, longitude);
        mapView.setCenter(placeJaude);
        mapView.setZoom(15.0);  // Zoom sur la ville

        // Créer une couche personnalisée pour afficher un marqueur
        LampadaireLayer lampadaireLayer = new LampadaireLayer(lampadaires);

        // Ajouter la couche à la carte
        mapView.addLayer(lampadaireLayer);

        // Créer la scène et ajouter la carte
        StackPane root = new StackPane();
        root.getChildren().add(mapView);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Carte centrée sur Place Jaude, Clermont-Ferrand");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



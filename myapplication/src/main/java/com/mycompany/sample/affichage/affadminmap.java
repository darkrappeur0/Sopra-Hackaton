package com.mycompany.sample.affichage;

import com.gluonhq.attach.display.DisplayService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.visual.Swatch;

import javafx.animation.AnimationTimer;
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

public class affadminmap {

    private static double previousZoom;
    private static MapPoint previousCenter;

    
    public static class LampadaireLayer extends MapLayer {

        private final List<MapPoint> lampadairePoints;
        private final Image lampadaireIcon;
    
        public LampadaireLayer(List<MapPoint> lampadairePoints) {
            this.lampadairePoints = lampadairePoints;
            this.lampadaireIcon = new Image(getClass().getResource("/images/icones/lampadaire.png").toExternalForm()); // Icône de lampadaire
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



    public static Scene getScene(Stage primaryStage) {
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

        // Initialiser les variables pour le suivi des changements
        previousZoom = mapView.getZoom();
        previousCenter = mapView.getCenter();

        // Créer un AnimationTimer pour surveiller les changements
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Vérification des propriétés de la carte avec un seuil
                if (Math.abs(mapView.getZoom() - previousZoom) > 0.01 || 
                    Math.abs(mapView.getCenter().getLatitude() - previousCenter.getLatitude()) > 0.0001 || 
                    Math.abs(mapView.getCenter().getLongitude() - previousCenter.getLongitude()) > 0.0001) {
                    lampadaireLayer.layoutLayer();  // Recalculer les positions
                    previousZoom = mapView.getZoom();
                    previousCenter = mapView.getCenter();
                }
            }
        };
        timer.start();  // Démarrer le timer


        // Créer la scène et ajouter la carte
        StackPane root = new StackPane();
        root.getChildren().add(mapView);

        Scene scene = new Scene(root, 1000, 700);

        return scene;


    }
}



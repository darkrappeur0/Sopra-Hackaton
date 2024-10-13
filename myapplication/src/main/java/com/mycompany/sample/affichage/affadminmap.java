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
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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
        private final List<Node> icons; // Liste pour stocker les icônes de lampadaire
    
        public LampadaireLayer(List<MapPoint> lampadairePoints) {
            this.lampadairePoints = lampadairePoints;
            this.lampadaireIcon = new Image(getClass().getResource("/images/icones/lampadaire.png").toExternalForm()); // Icône de lampadaire
            this.icons = new ArrayList<>(); // Initialiser la liste d'icônes
        
            // Initialiser les icônes une fois
            for (int i = 0; i < lampadairePoints.size(); i++) {
                Node icon = new ImageView(lampadaireIcon);
                icons.add(icon); // Ajouter chaque icône à la liste
                getChildren().add(icon); // Ajouter à la couche
            }
        }
    
        @Override
        // protected void layoutLayer() {
        //     //getChildren().clear(); // Nettoie les marqueurs précédents
    
        //     for (MapPoint point : lampadairePoints) {
                
        //         Point2D mapPoint = baseMap.getMapPoint(point.getLatitude(), point.getLongitude());
    
        //         if (mapPoint != null) {
        //             Node icon = icons.get(i); // Récupérer l'icône préexistante
        //             icon.setTranslateX(mapPoint.getX());
        //             icon.setTranslateY(mapPoint.getY());
                    
        //     }
        // }
        protected void layoutLayer() {
            for (int i = 0; i < lampadairePoints.size(); i++) {
                MapPoint point = lampadairePoints.get(i);
                Point2D mapPoint = baseMap.getMapPoint(point.getLatitude(), point.getLongitude());
    
                if (mapPoint != null) {
                    Node icon = icons.get(i); // Récupérer l'icône préexistante
                    icon.setTranslateX(mapPoint.getX());
                    icon.setTranslateY(mapPoint.getY());
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


        Button but2 = new Button("Assistance-Messagerie");
        Button but3 = new Button("Compte");
        ComboBox<String> lieu = new ComboBox<>();
        GridPane grid = new GridPane();
        StackPane root = new StackPane();
        Rectangle blueSquare = new Rectangle(1010, 360); // Largeur et hauteur du carré
        

        // Modification du carée
        blueSquare.setFill(Color.NAVY);  // Remplir le carré avec la couleur bleue

        /* 
         *              Set up de la selection des lieu
         * 
         */

        lieu.setEditable(true); //possible a écrit sur cette selection
        lieu.getItems().addAll("12/10/2024,23:30,71 Bd François Mitterrand 63000 Clermont-Ferrand ,lampadaire éteint","11/10/2024,23:20,33 Rue du Sable d'Etampes 63400 Chamalières,lampadaire allumée"
        ,"12/10/2024,23:10,66 Rue André Theuriet 63000 Clermont-Ferrand,lampadaire éteint","13/10/2024,22:40,23 Rue Horace Vernet 63000 Clermont-Ferrand,lampadaire allumée","10/10/2024,21:50,113 Av. Joseph Claussat 63400 Chamalières,lampadaire allumée");

         
        /*
         * 
         *              Set up de la grille
         * 
         */

         grid.setHgap(10);
        grid.setVgap(10);
        

        grid.setPickOnBounds(false);  // Permet aux clics en dehors des composants de passer à la carte
        grid.setMouseTransparent(false);  // Rendre les boutons et autres interactifs


        //remplissage de la grille par les différents éléments


         grid.add(blueSquare, 0, 42);  // Positionne le carré en bas
        
         // Placer le bouton but2 en bas à droite du carré bleu
         GridPane.setConstraints(but2, 1, 42);  // Positionner à la droite du carré bleu
         grid.add(but2, 0, 42);  // Ajouter le bouton dans la même cellule que le carré bleu
         GridPane.setHalignment(but2, javafx.geometry.HPos.RIGHT);  // Aligner à droite
         GridPane.setValignment(but2, javafx.geometry.VPos.BOTTOM); // Aligner en bas
 
         // Ajouter la ComboBox au milieu du carré bleu
         grid.add(lieu, 0, 42);  // Ajout dans la même cellule
         GridPane.setColumnSpan(lieu, 2); // Faire en sorte qu'il prenne toute la largeur du carré
         GridPane.setValignment(lieu, javafx.geometry.VPos.CENTER); // Aligner verticalement au centre
         GridPane.setHalignment(lieu, javafx.geometry.HPos.CENTER); // Aligner horizontalement au centre
         
         // Placer le bouton but3 en haut à droite de l'écran
         grid.add(but3, 0, 0);  // Ajouter le bouton
 

        //remplissage du noeud root par les différents éléments
        root.getChildren().addAll(mapView,grid);


        /*
         * 
         *          Intéraction des boutons
         * 
         */
        but2.setOnAction(e -> {
            Scene assismesScene = AffRapport.getScene(primaryStage);
            primaryStage.setScene(assismesScene);  // Changer de scène
        }); 
        but3.setOnAction(e -> {
            Scene aaaaa = AffadminCompte.getScene(primaryStage,"test","admin","test");
            primaryStage.setScene(aaaaa);  // Changer de scène
        });

        //création et renvoie de la scène
        Scene scene = new Scene(root, 1000, 800);

        return scene;


    }
}



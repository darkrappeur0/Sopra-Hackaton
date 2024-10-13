package com.mycompany.sample.affichage;
/*      Importation de bibliotèque java */
import java.util.Arrays;
import java.util.List;

/*      Importation de bibliotèque javaFX */
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/*      Importation de bibliotèque gluonhq */

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;





public class affichmap {

    public static class LampadaireLayer extends MapLayer {

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

        /*                  
        *
        *            Initialisation de tout les objets et affichage 
        *
        */

        Button but2 = new Button("Assistance-Messagerie");
        Button but3 = new Button("Compte");
        ComboBox<String> lieu = new ComboBox<>();
        GridPane grid = new GridPane();
        StackPane root = new StackPane();
        Rectangle blueSquare = new Rectangle(440, 310); // Largeur et hauteur du carré
        

        // Modification du carée
        blueSquare.setFill(Color.BLUE);  // Remplir le carré avec la couleur bleue

        /* 
         *              Set up de la selection des lieu
         * 
         */

        lieu.setEditable(true); //possible a écrit sur cette selection
        lieu.getItems().addAll("Pl. de Jaude, 63000 Clermont-Ferrand",
        "51 Av. des États Unis, 63000 Clermont-Ferrand","Pl. Louis Aragon, 63000 Clermont-Ferrand",
        "11 Rue Saint-Adjutor, 63000 Clermont-Ferrand","63170 Aubière","11 Bd Charles de Gaulle ",
         " 63000 Clermont-Ferrand","3 Rue Claude Baccot, 63000 Clermont-Ferrand");

         
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
            Scene assismesScene = AssisMes.getScene(primaryStage);
            primaryStage.setScene(assismesScene);  // Changer de scène
        }); 
        but3.setOnAction(e -> {
            Scene aaaaa = AffCompte.getScene(primaryStage,"test","user","test");
            primaryStage.setScene(aaaaa);  // Changer de scène
        });

        //création et renvoie de la scène
        Scene scene = new Scene(root, 400, 750);

        return scene;
    }

}
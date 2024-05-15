package App;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.*;



public class main extends Application {
    Integer directionJoueurA = -1;
    Integer directionJoueurB = -1;
    Double RotateJoueurA = -1.0;
    Double RotateJoueurB = -1.0;
    String Bleu = "#2ddff3";
    String Rose = "#F33A6A";
    String Orange = "#FF8C00";
    private Vehicule JoueurA;
    private Vehicule JoueurB;

    public void game(Stage secondStage,Vehicule JoueurA, Vehicule JoueurB){
            System.out.println("Start la page");

            //Bordure de la page
            Rectangle border = new Rectangle(1067, 683);
            border.setStroke(Color.web("#ff4467"));
            border.setFill(Color.TRANSPARENT);
            border.setStrokeWidth(10);

            BorderStroke borderStroke = new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(20));

            //Image de fond
            Image backgroundImage = new Image("file:assets/Background.jpeg");
            ImageView backgroundImageView = new ImageView(backgroundImage);
            backgroundImageView.fitWidthProperty().bind(secondStage.widthProperty());
            backgroundImageView.fitHeightProperty().bind(secondStage.heightProperty());

            Pane root = new Pane();
            Pane Trainer = new Pane();
            root.getChildren().add(backgroundImageView);
            root.getChildren().add(border);
            Scene scene = new Scene(new Pane(), 1080, 720);

            ControllerObject ControllerObject = new ControllerObject(JoueurA, JoueurB);

            ControllerVehicule ControllerJoueurA = new ControllerVehicule(JoueurA, scene, Trainer);
            ControllerVehicule ControllerJoueurB = new ControllerVehicule(JoueurB, scene, Trainer);

            ControllerJoueurA.setCouleur(Orange);
            ControllerJoueurB.setCouleur(Rose);

            ((Pane) scene.getRoot()).getChildren().addAll(root, Trainer);

            ControllerJoueurA.setvehiculeX(200.0);
            ControllerJoueurA.setvehiculeY(360.0);

            ControllerJoueurB.setvehiculeX(880.0);
            ControllerJoueurB.setvehiculeY(360.0);

            ControllerJoueurA.Spawn(scene);
            ControllerJoueurB.Spawn(scene);

            secondStage.setResizable(false);
            secondStage.setTitle("Jeu Tron");

            Timeline timeline = new Timeline();
            double borderWidth = borderStroke.getWidths().getTop();

            //TODO Fusionner les deux car la deuxième timelines désactive la première
            ControllerObject.lastSpawn = System.currentTimeMillis();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2), event -> {
                ControllerJoueurA.clear();
                ControllerJoueurB.clear();
                if (ControllerObject.isObjectSpawnable()){
                    ControllerObject.spawnUnObjet(scene);
                }
            }));

            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            AnimationTimer JoueurTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    scene.setOnKeyReleased(event -> {
                        if (event.getCode() == KeyCode.O) {
                            if (directionJoueurB != 1 && RotateJoueurB != 0.0) {
                                directionJoueurB = 0;
                                RotateJoueurB = 0.0;
                                ControllerJoueurB.setRotate(0.0);
                            }

                        } else if (event.getCode() == KeyCode.L) {
                            if (directionJoueurB != 0 && RotateJoueurB != 1.0) {
                                directionJoueurB = 1;
                                RotateJoueurB = 1.0;
                                ControllerJoueurB.setRotate(1.0);
                            }

                        } else if (event.getCode() == KeyCode.K && RotateJoueurB != 2.0) {
                            if (directionJoueurB != 3) {
                                directionJoueurB = 2;
                                RotateJoueurB = 2.0;
                                ControllerJoueurB.setRotate(2.0);
                            }

                        } else if (event.getCode() == KeyCode.M && RotateJoueurB != 3.0) {
                            if (directionJoueurB != 2) {
                                directionJoueurB = 3;
                                ControllerJoueurB.setRotate(3.0);
                                RotateJoueurB = 3.0;
                            }

                        } else if (event.getCode() == KeyCode.Z) {
                            if (directionJoueurA != 1 && RotateJoueurA != 0.0) {
                                directionJoueurA = 0;
                                ControllerJoueurA.setRotate(0.0);
                                RotateJoueurA = 1.0;
                            }

                        } else if (event.getCode() == KeyCode.S) {
                            if (directionJoueurA != 0 && RotateJoueurA != 1.0) {
                                directionJoueurA = 1;
                                ControllerJoueurA.setRotate(1.0);
                                RotateJoueurA = 1.0;
                            }

                        } else if (event.getCode() == KeyCode.Q) {
                            if (directionJoueurA != 3 && RotateJoueurA != 2.0 ) {
                                directionJoueurA = 2;
                                ControllerJoueurA.setRotate(2.0);
                                RotateJoueurA = 2.0;

                            }

                        } else if (event.getCode() == KeyCode.D) {
                            if (directionJoueurA != 2 && RotateJoueurA != 3.0) {
                                directionJoueurA = 3;
                                ControllerJoueurA.setRotate(3.0);
                                RotateJoueurA = 3.0;
                            }
                        }
                    });
                    switch (directionJoueurB) {
                        case 0:
                            ControllerJoueurB.MoveY(-ControllerJoueurB.getVitesse());
                            break;
                        case 1:
                            ControllerJoueurB.MoveY(ControllerJoueurB.getVitesse());
                            break;
                        case 2:
                            ControllerJoueurB.MoveX(-ControllerJoueurB.getVitesse());
                            break;
                        case 3:
                            ControllerJoueurB.MoveX(ControllerJoueurB.getVitesse());
                            break;
                    }

                    switch (directionJoueurA) {
                        case 0:
                            ControllerJoueurA.MoveY(-ControllerJoueurA.getVitesse());
                            break;
                        case 1:
                            ControllerJoueurA.MoveY(ControllerJoueurA.getVitesse());
                            break;
                        case 2:
                            ControllerJoueurA.MoveX(-ControllerJoueurA.getVitesse());
                            break;
                        case 3:
                            ControllerJoueurA.MoveX(ControllerJoueurA.getVitesse());
                            break;
                    }

                    ControllerJoueurA.drawLine();
                    ControllerJoueurB.drawLine();

                    ControllerJoueurA.detectCollision(ControllerJoueurB.getVehiculeTcoord(), ControllerJoueurB.getVehiculeX(), ControllerJoueurB.getVehiculeY());
                    ControllerJoueurB.detectCollision(ControllerJoueurA.getVehiculeTcoord(), ControllerJoueurA.getVehiculeX(), ControllerJoueurA.getVehiculeY());

                    ControllerObject.isVehiculeOn(JoueurA, scene);
                    ControllerObject.isVehiculeOn(JoueurB, scene);

                    if (ControllerJoueurA.isDead()) {
                        System.out.println("Le joueur A à perdu");
                        this.stop();
                    } else if (ControllerJoueurB.isDead()) {
                        System.out.println("Le joueur B à perdu");
                        this.stop();
                    }
                    if( ControllerJoueurA.getPane().getBoundsInParent().getMinX() <= borderWidth - 15 ||
                            ControllerJoueurA.getPane().getBoundsInParent().getMinY() <= borderWidth - 15 ||
                            ControllerJoueurA.getPane().getBoundsInParent().getMaxX() >= root.getWidth() - borderWidth  ||
                            ControllerJoueurA.getPane().getBoundsInParent().getMaxY() >= root.getHeight() - borderWidth - 28) {
                        ControllerJoueurA.setPtsVie(-1);
                        //System.out.println("JoueurA a toucher la bordure");
                    }
                    if( ControllerJoueurB.getPane().getBoundsInParent().getMinX() <= borderWidth - 15  ||
                            ControllerJoueurB.getPane().getBoundsInParent().getMinY() <= borderWidth - 15 ||
                            ControllerJoueurB.getPane().getBoundsInParent().getMaxX() >= root.getWidth() - borderWidth ||
                            ControllerJoueurB.getPane().getBoundsInParent().getMaxY() >= root.getHeight() - borderWidth - 28) {
                        ControllerJoueurB.setPtsVie(-1);
                        //System.out.println("JoueurB a toucher la bordure");
                    }
                }
            };

            //playMusic();
            JoueurTimer.start();
            secondStage.setScene(scene);
            secondStage.show();
        }


        @Override
    public void start(Stage primaryStage) {
        // Création de l'usine de véhicules
        VehiculeFactory Factory = new VehiculeFactory();

        // Initialisation des joueurs avec des voitures par défaut
        JoueurA = Factory.CreateVehicule(VehiculeType.VOITURE);
        JoueurB = Factory.CreateVehicule(VehiculeType.VOITURE);


        // Création des menus déroulants
        MenuButton ma = new MenuButton("Joueur A");
        ma.setStyle("-fx-background-color: #eca430; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-font-size: 15; -fx-font-weight: bold");
        ma.getItems().addAll(
                new MenuItem("Arcee"),
                new MenuItem("Bumblee"),
                new MenuItem("Optimus Prime")
        );

        MenuButton mb = new MenuButton("Joueur B");
        mb.setStyle("-fx-background-color: #F33A6A; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-font-size: 15; -fx-font-weight: bold");
        mb.getItems().addAll(
                new MenuItem("Arcee"),
                new MenuItem("Bumblebee"),
                new MenuItem("Optimus Prime")
        );

        // Gestion des actions de sélection de véhicule pour le joueur A
        ma.getItems().get(0).setOnAction(event -> {
            System.out.println("Moto sélectionnée");
            JoueurA = Factory.CreateVehicule(VehiculeType.MOTO);
            ma.setText("Arcee");
        });

        ma.getItems().get(1).setOnAction(event -> {
            System.out.println("Voiture sélectionnée");
            JoueurA = Factory.CreateVehicule(VehiculeType.VOITURE);
            ma.setText("Bumblebee");
        });

        ma.getItems().get(2).setOnAction(event -> {
            System.out.println("Camion sélectionnée");
            JoueurA = Factory.CreateVehicule(VehiculeType.CAMION);
            ma.setText("Optimus Prime");
        });

        // Gestion des actions de sélection de véhicule pour le joueur B
        mb.getItems().get(0).setOnAction(event -> {
            System.out.println("Moto sélectionnée");
            JoueurB = Factory.CreateVehicule(VehiculeType.MOTO);
            mb.setText("Arcee");
        });

        mb.getItems().get(1).setOnAction(event -> {
            System.out.println("Voiture sélectionnée");
            JoueurB = Factory.CreateVehicule(VehiculeType.VOITURE);
            mb.setText("Bumblebee");
        });

        mb.getItems().get(2).setOnAction(event -> {
            System.out.println("Camion sélectionnée");
            JoueurB = Factory.CreateVehicule(VehiculeType.CAMION);
            mb.setText("Optimus Prime");
        });


        Button playButton =  new Button("PLAY");
        playButton.setPrefWidth(100);
        playButton.setPrefHeight(40);
        playButton.setStyle("-fx-background-color: #3f3f3f; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 12px; -fx-font-size: 15; -fx-font-weight: bold;");


        // Création du layout principal
        BorderPane rootMenu = new BorderPane();

        Image backgroundImage = new Image("file:assets/TestBG.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(rootMenu.widthProperty());
        backgroundImageView.fitHeightProperty().bind(rootMenu.heightProperty());

        rootMenu.getChildren().add(backgroundImageView);

        playButton.setOnMouseEntered(e -> {
            playButton.setStyle("-fx-background-color: #2c2b2b; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 12px; -fx-font-size: 15; -fx-font-weight: bold;");
            rootMenu.setCursor(Cursor.HAND);
        });

        playButton.setOnMouseExited(e -> {
            playButton.setStyle("-fx-background-color: #3f3f3f; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 12px; -fx-font-size: 15; -fx-font-weight: bold;");
            rootMenu.setCursor(Cursor.DEFAULT);
        });

        ma.setOnMouseEntered(e -> {
            ma.setStyle("-fx-background-color: #b87f24; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-font-size: 15; -fx-font-weight: bold");
            rootMenu.setCursor(Cursor.HAND);
        });

        ma.setOnMouseExited(e -> {
            ma.setStyle("-fx-background-color: #eca430; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-font-size: 15; -fx-font-weight: bold");
            rootMenu.setCursor(Cursor.DEFAULT);
        });

        mb.setOnMouseEntered(e -> {
            mb.setStyle("-fx-background-color: #c6325a; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-font-size: 15; -fx-font-weight: bold");
            rootMenu.setCursor(Cursor.HAND);
        });

        mb.setOnMouseExited(e -> {
            mb.setStyle("-fx-background-color: #F33A6A; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-font-size: 15; -fx-font-weight: bold");
            rootMenu.setCursor(Cursor.DEFAULT);
        });

        rootMenu.setCenter(playButton);
        HBox menuBox = new HBox(ma, mb);
        menuBox.setSpacing(10); // Définir l'espace entre les MenuButtons
        menuBox.setAlignment(Pos.CENTER); // Aligner les MenuButtons à gauche

        rootMenu.setTop(menuBox);
        //BorderPane.setMargin(playButton, new Insets(0, 0, 0, 160));
        BorderPane.setMargin(menuBox, new Insets(30, 0, 10, 0));

        // Gestion de l'action du menu "New Game"
        playButton.setOnAction(event -> {
            Stage secondStage = new Stage();

            directionJoueurA = -1;
            directionJoueurB = -1;
            RotateJoueurA = -1.0;
            RotateJoueurB = -1.0;
            // Définition des propriétés du stage
            secondStage.setTitle("Deuxième fenêtre");
            secondStage.setWidth(1080);
            secondStage.setHeight(720);

            // Création d'une nouvelle scène avec du contenu
            VBox root = new VBox();
            root.getChildren().add(new Label("Contenu de la deuxième fenêtre"));
            Scene scene = new Scene(root);

            // Définition de la scène du stage
            secondStage.setScene(scene);
            game(secondStage, JoueurA, JoueurB);
        });

        // Création de la scène principale
        Scene scene = new Scene(rootMenu, 420, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("My Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


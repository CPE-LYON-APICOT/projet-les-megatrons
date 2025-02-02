package App;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.util.Duration;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.*;

import java.nio.file.Paths;


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

    MediaPlayer mediaPlayer;

    MediaPlayer soundEffect;

    public void musicMenu(){
        String s = "assets/menuOST.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.setVolume(0.4);
        mediaPlayer.play();
    }

    public void soundEffectGameFinish(){
        String s = "assets/soundEffect_GameFinish.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffect = new MediaPlayer(h);
        soundEffect.play();
    }

    public void soundEffectTakeObject(){
        String s = "assets/soundEffect_TakeObject.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffect = new MediaPlayer(h);
        soundEffect.play();
    }

    public void musicStop(){
        mediaPlayer.stop();
    }

    public void musicGame(){
        String s = "assets/gameOST.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.setVolume(0.4);
        mediaPlayer.play();
    }

    public void game(Stage secondStage,Vehicule JoueurA, Vehicule JoueurB){
        musicStop();
        musicGame();

        Rectangle border = new Rectangle(1067, 683);
        border.setStroke(Color.web("#ff4467"));
        border.setFill(Color.TRANSPARENT);
        border.setStrokeWidth(10);

        BorderStroke borderStroke = new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(20));

        //Image de fond
        Image backgroundImage = new Image("file:assets/Test.jpg");
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
        secondStage.setTitle("Mega-Tron");

        Timeline timeline = new Timeline();
        double borderWidth = borderStroke.getWidths().getTop();

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
                    /*if (event.getCode() == KeyCode.G) {
                        togglePause();

                    } else*/
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

                if (ControllerJoueurA.detectCollisionBetwCar(JoueurB)){
                    loose(root, 3);
                    timeline.stop();
                    this.stop();
                }else {
                    ControllerJoueurA.detectCollision(ControllerJoueurB.getVehiculeTcoord(), ControllerJoueurB.getVehiculeX(), ControllerJoueurB.getVehiculeY());
                    ControllerJoueurB.detectCollision(ControllerJoueurA.getVehiculeTcoord(), ControllerJoueurA.getVehiculeX(), ControllerJoueurA.getVehiculeY());
                }

                if (ControllerObject.isVehiculeOn(JoueurA, scene)){
                    soundEffectTakeObject();
                }

                if (ControllerObject.isVehiculeOn(JoueurB, scene)){
                    soundEffectTakeObject();
                }

                if (ControllerJoueurA.isDead()) {
                    loose(root, 1);
                    timeline.stop();
                    this.stop();
                } else if (ControllerJoueurB.isDead()) {
                    loose(root, 2);
                    timeline.stop();
                    this.stop();
                }

                if( ControllerJoueurA.getPane().getBoundsInParent().getMinX() <= borderWidth - 20 ||
                        ControllerJoueurA.getPane().getBoundsInParent().getMinY() <= borderWidth - 20 ||
                        ControllerJoueurA.getPane().getBoundsInParent().getMaxX() >= root.getWidth() - borderWidth  ||
                        ControllerJoueurA.getPane().getBoundsInParent().getMaxY() >= root.getHeight() - borderWidth - 20) {
                    ControllerJoueurA.retirerPtsVie(1);
                }
                if( ControllerJoueurB.getPane().getBoundsInParent().getMinX() <= borderWidth - 20  ||
                        ControllerJoueurB.getPane().getBoundsInParent().getMinY() <= borderWidth - 20 ||
                        ControllerJoueurB.getPane().getBoundsInParent().getMaxX() >= root.getWidth() - borderWidth ||
                        ControllerJoueurB.getPane().getBoundsInParent().getMaxY() >= root.getHeight() - borderWidth - 20) {
                    ControllerJoueurB.retirerPtsVie(1);
                }
            }
        };

        JoueurTimer.start();
        secondStage.setScene(scene);
        secondStage.getIcons().add(new Image("file:assets/Logo.png"));

        secondStage.show();

        }


        @Override
    public void start(Stage primaryStage) {
        VehiculeFactory Factory = new VehiculeFactory();
        musicMenu();

        JoueurA = Factory.CreateVehicule(VehiculeType.VOITURE);
        JoueurB = Factory.CreateVehicule(VehiculeType.VOITURE);

        MenuButton ma = new MenuButton("Joueur A");
        ma.setStyle("-fx-background-color: #eca430; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-font-size: 15; -fx-font-weight: bold; -fx-margin-right: 50%;");
        ma.getItems().addAll(
                new MenuItem("Arcee"),
                new MenuItem("Bumblee"),
                new MenuItem("Optimus Prime")
        );

        MenuButton mb = new MenuButton("Joueur B");
        mb.setStyle("-fx-background-color: #F33A6A; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-font-size: 15; -fx-font-weight: bold;");
        mb.getItems().addAll(
                new MenuItem("Arcee"),
                new MenuItem("Bumblebee"),
                new MenuItem("Optimus Prime")
        );

        ma.getItems().get(0).setOnAction(event -> {
            JoueurA = Factory.CreateVehicule(VehiculeType.MOTO);
            ma.setText("Arcee");
        });

        ma.getItems().get(1).setOnAction(event -> {
            JoueurA = Factory.CreateVehicule(VehiculeType.VOITURE);
            ma.setText("Bumblebee");
        });

        ma.getItems().get(2).setOnAction(event -> {
            JoueurA = Factory.CreateVehicule(VehiculeType.CAMION);
            ma.setText("Optimus Prime");
        });

        mb.getItems().get(0).setOnAction(event -> {
            JoueurB = Factory.CreateVehicule(VehiculeType.MOTO);
            mb.setText("Arcee");
        });

        mb.getItems().get(1).setOnAction(event -> {
            JoueurB = Factory.CreateVehicule(VehiculeType.VOITURE);
            mb.setText("Bumblebee");
        });

        mb.getItems().get(2).setOnAction(event -> {
            JoueurB = Factory.CreateVehicule(VehiculeType.CAMION);
            mb.setText("Optimus Prime");
        });


        Button playButton =  new Button("PLAY");
        playButton.setPrefWidth(100);
        playButton.setPrefHeight(40);
        playButton.setStyle("-fx-background-color: #3f3f3f; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-border-radius: 12px; -fx-font-size: 15; -fx-font-weight: bold;");

        BorderPane rootMenu = new BorderPane();

        Image backgroundImage = new Image("file:assets/menu.jpg");
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
        menuBox.setSpacing(30);
        menuBox.setAlignment(Pos.CENTER);

        rootMenu.setTop(menuBox);
        BorderPane.setMargin(menuBox, new Insets(30, 0, 10, 0));
        playButton.setOnAction(event -> {
            Stage secondStage = new Stage();
            directionJoueurA = -1;
            directionJoueurB = -1;
            RotateJoueurA = -1.0;
            RotateJoueurB = -1.0;
            secondStage.setTitle("Deuxième fenêtre");
            secondStage.setWidth(1080);
            secondStage.setHeight(720);

            VBox root = new VBox();
            root.getChildren().add(new Label("Contenu de la deuxième fenêtre"));
            Scene scene = new Scene(root);

            secondStage.setScene(scene);
            game(secondStage, JoueurA, JoueurB);
            primaryStage.close();
        });

        Scene scene = new Scene(rootMenu, 420, 260);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Mega-Tron");
        primaryStage.getIcons().add(new Image("file:assets/Logo.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void loose(Pane root, Integer Looser){
        musicStop();
        soundEffectGameFinish();
        Text stringFinal = new Text();
        stringFinal.setFont(Font.font("Verdana", FontWeight.BOLD, 60));
        stringFinal.setFill(Color.WHITE);

        double centerX = 100 - (stringFinal.getLayoutBounds().getWidth() / 2);
        double centerY = 360 - (stringFinal.getLayoutBounds().getHeight() / 2);
        stringFinal.setLayoutX(centerX);
        stringFinal.setLayoutY(centerY);

        switch(Looser){
            case 1:
                stringFinal.setText("Le joueur 2 à gagné !!!");
                break;
            case 2:
                stringFinal.setText("Le joueur 1 à gagné !!!");
                break;
            case 3:
                stringFinal.setText("Les deux joueurs ont perdu");
        }
        root.getChildren().add(stringFinal);
    }
}


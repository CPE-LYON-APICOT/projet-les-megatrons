package App;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;

public class main extends Application {
    Integer directionJoueurA = -1;
    Integer directionJoueurB = -1;
    Double RotateJoueurA = -1.0;
    Double RotateJoueurB = -1.0;



    @Override
    public void start(Stage primaryStage) {
        System.out.println("Start la page");

        //Bordure de la page
        Rectangle border = new Rectangle(1080, 720);
        border.setStroke(Color.web("#ff4467"));
        border.setFill(Color.TRANSPARENT);
        border.setStrokeWidth(10);

        BorderStroke borderStroke = new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(20));

        //Image de fond
        Image backgroundImage = new Image("file:assets/Background.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());

        VehiculeFactory Factory = new VehiculeFactory();

        Moto JoueurA = (Moto) Factory.CreateVehicule(VehiculeType.MOTO);
        Moto JoueurB = (Moto) Factory.CreateVehicule(VehiculeType.MOTO);

        Pane root = new Pane();
        Pane Trainer = new Pane();
        root.getChildren().add(backgroundImageView);
        root.getChildren().add(border);
        Scene scene = new Scene(new Pane(), 1080, 720);

        ControllerObject CO = new ControllerObject(JoueurA);
        //Invicibilite objInvicibilite = CO.objectInvicibilite(((Pane) scene.getRoot()));

        ControllerVehicule ControllerJoueurA = new ControllerVehicule(JoueurA, scene, Trainer);
        ControllerVehicule ControllerJoueurB = new ControllerVehicule(JoueurB, scene, Trainer);

        String Bleu = "#2ddff3";
        String Rose = "#F33A6A";
        ControllerJoueurA.setCouleur(Bleu);
        ControllerJoueurB.setCouleur(Rose);


        ((Pane) scene.getRoot()).getChildren().addAll(root, Trainer);

        ControllerJoueurA.setvehiculeX(200.0);
        ControllerJoueurA.setvehiculeY(360.0);

        ControllerJoueurB.setvehiculeX(880.0);
        ControllerJoueurB.setvehiculeY(360.0);

        ControllerJoueurA.Spawn(scene);
        ControllerJoueurB.Spawn(scene);
        //CO.placeObject(((Pane) scene.getRoot()),objInvicibilite);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Jeu Tron");

        Timeline timeline = new Timeline();
        double borderWidth = borderStroke.getWidths().getTop();


        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControllerJoueurA.clear();
                ControllerJoueurB.clear();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        int deplacement = 4;
        AnimationTimer JoueurTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                //System.out.println(direction);
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
                        ControllerJoueurB.MoveY(-deplacement);
                        break;
                    case 1:
                        ControllerJoueurB.MoveY(deplacement);
                        break;
                    case 2:
                        ControllerJoueurB.MoveX(-deplacement);
                        break;
                    case 3:
                        ControllerJoueurB.MoveX(deplacement);
                        break;
                }

                switch (directionJoueurA) {
                    case 0:
                        ControllerJoueurA.MoveY(-deplacement);
                        break;
                    case 1:
                        ControllerJoueurA.MoveY(deplacement);
                        break;
                    case 2:
                        ControllerJoueurA.MoveX(-deplacement);
                        break;
                    case 3:
                        ControllerJoueurA.MoveX(deplacement);
                        break;
                }

                ControllerJoueurA.drawLine();
                ControllerJoueurB.drawLine();

                ControllerJoueurA.detectCollision(ControllerJoueurB.getVehiculeTcoord(), ControllerJoueurB.getVehiculeX(), ControllerJoueurB.getVehiculeY());
                ControllerJoueurB.detectCollision(ControllerJoueurA.getVehiculeTcoord(), ControllerJoueurA.getVehiculeX(), ControllerJoueurA.getVehiculeY());

                if (ControllerJoueurA.isDead()) {
                    System.out.println("Le joueur A à perdu");
                    this.stop();
                } else if (ControllerJoueurB.isDead()) {
                    System.out.println("Le joueur B à perdu");
                    this.stop();
                }
                if( ControllerJoueurA.getPane().getBoundsInParent().getMinX() <= borderWidth  ||
                        ControllerJoueurA.getPane().getBoundsInParent().getMinY() <= borderWidth  ||
                        ControllerJoueurA.getPane().getBoundsInParent().getMaxX() >= root.getWidth() - borderWidth ||
                        ControllerJoueurA.getPane().getBoundsInParent().getMaxY() >= root.getHeight() - borderWidth) {
                    ControllerJoueurA.setPtsVie(-1);
                    //System.out.println("JoueurA a toucher la bordure");
                }
                if( ControllerJoueurB.getPane().getBoundsInParent().getMinX() <= borderWidth  ||
                        ControllerJoueurB.getPane().getBoundsInParent().getMinY() <= borderWidth  ||
                        ControllerJoueurB.getPane().getBoundsInParent().getMaxX() >= root.getWidth() - borderWidth ||
                        ControllerJoueurB.getPane().getBoundsInParent().getMaxY() >= root.getHeight() - borderWidth) {
                    ControllerJoueurB.setPtsVie(-1);
                    //System.out.println("JoueurB a toucher la bordure");
                }

                /*if (objInvicibilite.getPane().intersects(ControllerJoueurA.getPane().getBoundsInParent())){
                    System.out.println("objet Pris");

                    try {
                        CO.useObject(((Pane) scene.getRoot()),objInvicibilite);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }*/
            }
        };

        JoueurTimer.start();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


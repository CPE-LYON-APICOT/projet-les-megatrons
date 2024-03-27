package App;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
public class main extends Application {
    private Button bouton;
    Integer direction = 1;
    int rotate = 1;
    @Override
    public void start(Stage primaryStage) {
        System.out.println("Start la page");

        Rectangle border = new Rectangle(1080, 720);
        border.setStroke(Color.web("#ff4467"));
        border.setFill(Color.TRANSPARENT);
        border.setStrokeWidth(10);

        Image backgroundImage = new Image("file:assets/Background.jpg");

        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());


        //Rectangle rectangle = new Rectangle(50, 10, Color.RED);
        VehiculeFactory VF = new VehiculeFactory();
        Moto moto = (Moto) VF.CreateVehicule(VehiculeType.MOTO);

        moto.rectangle.setLayoutX(moto.PositionX);

        moto.rectangle.setLayoutY(moto.PositionY);

        Pane root = new Pane();
        Pane Trainer = new Pane();
        ControllerVehicule CV = new ControllerVehicule(moto, Trainer);

        root.getChildren().add(backgroundImageView);
        root.getChildren().add(moto.rectangle);
        root.getChildren().add(border);


        Scene scene = new Scene(new Pane(), 1080, 720);
        ((Pane) scene.getRoot()).getChildren().addAll(root, Trainer);


        primaryStage.setResizable(false);
        primaryStage.setTitle("Hello JavaFX");

        double deplacement = 3;


        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.Z) {
                direction = 1;
                if (rotate == 1){
                    moto.switchDirection();
                    rotate = 2;
                    moto.addLastCoord();
                }
            } else if (event.getCode() == KeyCode.S) {
                direction = 2;
                if (rotate == 1){
                    moto.switchDirection();
                    rotate = 2;
                    moto.addLastCoord();

                }
            } else if (event.getCode() == KeyCode.Q) {
                direction = 3;
                if (rotate == 2){
                    moto.switchDirection();
                    rotate = 1;
                    moto.addLastCoord();

                }
            } else if (event.getCode() == KeyCode.D) {
                direction = 4;
                if (rotate == 2){
                    moto.switchDirection();
                    rotate = 1;
                    moto.addLastCoord();

                }
            }else if(event.getCode() == KeyCode.B){
                CV.clear();
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                switch (direction) {
                    case 1:
                        moto.rectangle.setLayoutY(moto.rectangle.getLayoutY() - deplacement);
                        moto.addPositionY(-deplacement);
                        break;

                    case 2:
                        moto.rectangle.setLayoutY(moto.rectangle.getLayoutY() + deplacement);
                        moto.addPositionY(deplacement);
                        break;

                    case 3:
                        moto.rectangle.setLayoutX(moto.rectangle.getLayoutX() - deplacement);
                        moto.addPositionX(-deplacement);
                        break;

                    case 4:
                        moto.rectangle.setLayoutX(moto.rectangle.getLayoutX() + deplacement);
                        moto.addPositionX(deplacement);
                        break;
                }
                CV.drawLine();
            }
        };
        timer.start();



        /*
        scene.setOnKeyPressed(event -> {
            double deplacement = 10;
            if (event.getCode() == KeyCode.Z) {
                rectangle.setLayoutY(rectangle.getLayoutY() - deplacement);
            } else if (event.getCode() == KeyCode.S) {
                rectangle.setLayoutY(rectangle.getLayoutY() + deplacement);
            } else if (event.getCode() == KeyCode.Q) {
                rectangle.setLayoutX(rectangle.getLayoutX() - deplacement);
            } else if (event.getCode() == KeyCode.D) {
                rectangle.setLayoutX(rectangle.getLayoutX() + deplacement);
            }
        });*/

        CV.start();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


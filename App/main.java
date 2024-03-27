package App;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
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


        //Rectangle rectangle = new Rectangle(50, 10, Color.RED);
        Moto moto = new Moto(100,100,1,1,50,new Rectangle(50,10,Color.BLUE) );
        //moto.rectangle

        moto.rectangle.setLayoutX(100);

        moto.rectangle.setLayoutY(100);

        Pane root = new Pane();
        root.getChildren().add(moto.rectangle);

        Scene scene = new Scene(root, 1080, 720);


        primaryStage.setResizable(false);
        primaryStage.setTitle("Hello JavaFX");

        double deplacement = 3;


        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.Z) {
                direction = 1;
                if (rotate == 1){
                    moto.switchDirection();
                    rotate = 2;
                }
            } else if (event.getCode() == KeyCode.S) {
                direction = 2;
                if (rotate == 1){
                    moto.switchDirection();
                    rotate = 2;
                }
            } else if (event.getCode() == KeyCode.Q) {
                direction = 3;
                if (rotate == 2){
                    moto.switchDirection();
                    rotate = 1;
                }
            } else if (event.getCode() == KeyCode.D) {
                direction = 4;
                if (rotate == 2){
                    moto.switchDirection();
                    rotate = 1;
                }
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                switch (direction) {
                    case 1:
                        moto.rectangle.setLayoutY(moto.rectangle.getLayoutY() - deplacement);
                        break;
                    case 2:
                        moto.rectangle.setLayoutY(moto.rectangle.getLayoutY() + deplacement);
                        break;
                    case 3:
                        moto.rectangle.setLayoutX(moto.rectangle.getLayoutX() - deplacement);
                        break;
                    case 4:
                        moto.rectangle.setLayoutX(moto.rectangle.getLayoutX() + deplacement);
                        break;
                }
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

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


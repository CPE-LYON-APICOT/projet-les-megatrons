package App;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCode;


public class main extends Application {
    private Button bouton;
    @Override
    public void start(Stage primaryStage) {
        System.out.println("Start la page");

        bouton = new Button("Déplacement");
        bouton.setPrefWidth(200);
        bouton.setPrefHeight(50);
        bouton.setLayoutX(100);
        bouton.setLayoutY(100);

        Pane root = new Pane();
        root.getChildren().add(bouton);

        Scene scene = new Scene(root, 1080, 720);


        primaryStage.setResizable(false);
        primaryStage.setTitle("Hello JavaFX");

        scene.setOnKeyReleased(event -> {
            double deplacement = 10;
            if (event.getCode() == KeyCode.Z) {
                bouton.setLayoutY(bouton.getLayoutY() - deplacement);
            } else if (event.getCode() == KeyCode.S) {
                bouton.setLayoutY(bouton.getLayoutY() + deplacement);
            } else if (event.getCode() == KeyCode.Q) {
                bouton.setLayoutX(bouton.getLayoutX() - deplacement);
            } else if (event.getCode() == KeyCode.D) {
                bouton.setLayoutX(bouton.getLayoutX() + deplacement);
            }
        });

        scene.setOnKeyPressed(event -> {
            double deplacement = 10;
            if (event.getCode() == KeyCode.Z) {
                bouton.setLayoutY(bouton.getLayoutY() - deplacement);
            } else if (event.getCode() == KeyCode.S) {
                bouton.setLayoutY(bouton.getLayoutY() + deplacement);
            } else if (event.getCode() == KeyCode.Q) {
                bouton.setLayoutX(bouton.getLayoutX() - deplacement);
            } else if (event.getCode() == KeyCode.D) {
                bouton.setLayoutX(bouton.getLayoutX() + deplacement);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


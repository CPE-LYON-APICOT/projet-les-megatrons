package App;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Object {
    private Pane pane;
    private ImageView sprite;
    private double x;
    private double y;
    private objectType type;



    public Object(String imagePath, double x, double y, objectType type) {
        this.x = x;
        this.y = y;
        this.type = type;

        // crée un objet ImageView à partir de l'image spécifiée
        this.sprite = new ImageView(new Image(imagePath));

        // crée un objet Pane pour contenir l'image
        this.pane = new Pane();
        this.pane.getChildren().add(sprite);

        // définit la position de l'image dans le Pane
        this.sprite.setX(x);
        this.sprite.setY(y);
    }

    public objectType getType() {
        return type;
    }

    public void setType(objectType type) {
        this.type = type;
    }
    public Pane getPane() {
        return pane;
    }

    public ImageView getSprite() {
        return sprite;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
        this.sprite.setX(x);
    }

    public void setY(double y) {
        this.y = y;
        this.sprite.setY(y);
    }
}


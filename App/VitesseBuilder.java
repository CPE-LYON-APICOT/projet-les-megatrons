package App;

import javafx.scene.image.ImageView;

public class VitesseBuilder {
    private String sprite;
    private double x;
    private double y;
    private int duration;
    private int bonusVitesse;

    public VitesseBuilder setSprite(String sprite) {
        this.sprite = sprite;
        return this;
    }

    public VitesseBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public VitesseBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public VitesseBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public VitesseBuilder setBonusVitesse(int bonusVitesse) {
        this.bonusVitesse = bonusVitesse;
        return this;
    }

    public Vitesse build() {
        Vitesse vitesse = new Vitesse(sprite, x, y);
        vitesse.setDuration(duration);
        vitesse.setBonusvitesse(bonusVitesse);
        return vitesse;
    }
}

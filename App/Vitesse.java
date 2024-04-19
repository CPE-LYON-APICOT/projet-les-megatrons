package App;

import javafx.scene.image.ImageView;

public class Vitesse  extends Object{
    private int duration;
    private int Bonusvitesse;

    public Vitesse(ImageView sprite, double x, double y) {
        super(sprite, x, y, objectType.VITESSE);
        this.duration = 5;
        this.Bonusvitesse = 5;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getBonusvitesse() {
        return Bonusvitesse;
    }

    public void setBonusvitesse(int bonusvitesse) {
        Bonusvitesse = bonusvitesse;
    }


}

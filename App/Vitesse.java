package App;

import javafx.scene.image.ImageView;

public class Vitesse  extends Object{

    private int Bonusvitesse;

    public Vitesse(String sprite, double x, double y) {
        super(sprite, x, y, objectType.VITESSE,5, System.currentTimeMillis());

        this.Bonusvitesse = 10;
    }

    public int getBonusvitesse() {
        return Bonusvitesse;
    }

    public void setBonusvitesse(int bonusvitesse) {
        Bonusvitesse = bonusvitesse;
    }


}

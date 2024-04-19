package App;

import javafx.scene.image.ImageView;

public class Invicibilite extends  Object{

    private int duration;
    private int pvBonus;


    public Invicibilite(ImageView sprite, double x, double y) {
        super(sprite, x, y,objectType.INVICIBILITE);
        this.duration = 5;
        this.pvBonus = 9999;

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public int getPvBonus() {
        return pvBonus;
    }

    public void setPvBonus(int pvBonus) {
        this.pvBonus = pvBonus;
    }





}

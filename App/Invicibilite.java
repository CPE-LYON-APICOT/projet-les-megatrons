package App;

import javafx.scene.image.ImageView;

public class Invicibilite extends Object{

    private int pvBonus;

    public Invicibilite(String sprite, double x, double y) {
        super(sprite, x, y,objectType.INVICIBILITE,5, System.currentTimeMillis());
        this.pvBonus = 9999;

    }

    public int getPvBonus() {
        return pvBonus;
    }

    public void setPvBonus(int pvBonus) {
        this.pvBonus = pvBonus;
    }





}

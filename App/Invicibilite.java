package App;

public class Invicibilite extends  Object{

    private int duration;
    private int pvBonus;


    public Invicibilite(String imagePath, double x, double y) {
        super(imagePath, x, y,objectType.INVICIBILITE);
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

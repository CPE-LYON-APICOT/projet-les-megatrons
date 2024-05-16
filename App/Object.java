package App;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Object {
    protected Pane PanelImage;
    private String sprite;
    private double x;
    private double y;
    private objectType type;
    private int duration;
    private long heureSpawn;

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    private boolean isUse = false;
    public Object(String LienImage, double x, double y, objectType type, int duration, long heureSpawn) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.duration = duration;
        this.sprite = LienImage;
        this.heureSpawn = heureSpawn;
    }

    public objectType getType() {
        return type;
    }

    public void setType(objectType type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duree) {
        this.duration = duree;
    }

    public Pane getPanelImage() {
        return PanelImage;
    }

    public void setPanelImage(Pane panelImage) {
        PanelImage = panelImage;
    }

}


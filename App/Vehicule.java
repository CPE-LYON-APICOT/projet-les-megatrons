package App;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Vehicule {
    protected int PositionX;
    protected int PositionY;
    protected int PtsVieBase;
    protected int PtsVie;
    protected int TDuree;
    protected int TLargeur;
    protected  int TLongueur;
    protected Color TCouleur;
    protected Rectangle rectangle;

    public Vehicule(int positionX, int positionY, int ptsVieBase, int ptsVie, int TDuree,Rectangle rectangle) {
        PositionX = positionX;
        PositionY = positionY;
        PtsVieBase = ptsVieBase;
        PtsVie = ptsVie;
        this.TDuree = TDuree;
        this.rectangle = rectangle;

    }
}

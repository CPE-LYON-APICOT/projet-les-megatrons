package App;

import javafx.scene.paint.Color;

public class Vehicule {
    protected int PositionX;
    protected int PositionY;
    protected int PtsVieBase;
    protected int PtsVie;
    protected int TDuree;
    protected int TLargeur;
    protected Color TCouleur;

    public Vehicule(int positionX, int positionY, int ptsVieBase, int ptsVie, int TDuree, int TLargeur, Color TCouleur) {
        PositionX = positionX;
        PositionY = positionY;
        PtsVieBase = ptsVieBase;
        PtsVie = ptsVie;
        this.TDuree = TDuree;
        this.TLargeur = TLargeur;
        this.TCouleur = TCouleur;
    }
}

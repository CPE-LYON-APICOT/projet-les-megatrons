package App;

import javafx.scene.paint.Color;

public class Moto extends Vehicule{
    private int LargeurMoto = 50;
    private int HauteurMoto = 50;

    public Moto(int positionX, int positionY, int ptsVieBase, int ptsVie, int TDuree, int TLargeur, Color TCouleur) {
        super(positionX, positionY, ptsVieBase, ptsVie, TDuree, TLargeur, TCouleur);
    }
}

package App;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Moto extends Vehicule{
    private int LargeurMoto = 50;
    private int HauteurMoto = 50;
    //private Rectangle rectangle = new Rectangle(50, 10, Color.RED);


    public Moto(int positionX, int positionY, int ptsVieBase, int ptsVie, int TDuree, Rectangle rectangle, double vitesseTrainee) {
        super(positionX, positionY, ptsVieBase, ptsVie, TDuree, rectangle);
        this.VitesseTrainee = vitesseTrainee;
    }

    public Rectangle getRectangle(){
        return new Rectangle(TLargeur,TLongueur,TCouleur);
    }
    public void switchDirection(){
        System.out.println("SwitchDirection");
        int Largeur = (int) this.rectangle.getWidth();
        int Longueur = (int) this.rectangle.getHeight();
        this.rectangle.setHeight(Largeur);
        this.rectangle.setWidth(Longueur);
    }

}

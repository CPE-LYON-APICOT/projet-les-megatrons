package App;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Vehicule {
    protected double PositionX;
    protected double PositionY;
    protected int PtsVieBase;
    protected int PtsVie;
    protected int TDuree;
    protected int TLargeur;
    protected  int TLongueur;
    protected Color TCouleur;
    protected Rectangle rectangle;
    protected int Tlargeur = 5;

    protected List<List<Double>> Tcoords;

    public Vehicule(int positionX, int positionY, int ptsVieBase, int ptsVie, int TDuree,Rectangle rectangle) {
        PositionX = positionX;
        PositionY = positionY;
        PtsVieBase = ptsVieBase;
        PtsVie = ptsVie;
        this.TDuree = TDuree;
        this.rectangle = rectangle;

        Tcoords = new ArrayList<List<Double>>();
        List<Double> Coord = new ArrayList<Double>();
        Coord.add(PositionX);
        Coord.add(PositionY);
        Tcoords.add(Coord);

        System.out.println(Tcoords);
    }

    public void addLastCoord(){
        Tcoords.get(Tcoords.size() - 1).add(PositionX);
        Tcoords.get(Tcoords.size() - 1).add(PositionY);
        Tcoords.add(new ArrayList<>(Arrays.asList(PositionX, PositionY)));
        System.out.println(Tcoords);
    }

    public double getPositionX() {
        return PositionX;
    }

    public void addPositionX(double positionX) {
        PositionX = PositionX + positionX;
    }

    public double getPositionY() {
        return PositionY;
    }

    public void addPositionY(double positionY) {
        PositionY = PositionY + positionY;
    }

}

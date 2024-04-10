package App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Moto extends Vehicule{
    private int MotoHeight = 50;
    private int MotoWidth = 50;
    private double VitesseTrainee;
    public Moto(int PositionX, int PositionY, int PtsVieBase, int PtsVie, String LienImage, Double VitesseTrainee) {
        super(PositionX, PositionY, PtsVieBase, PtsVie, LienImage, VitesseTrainee);
    }

    @Override
    public double getPositionTrainerY() {
        /*System.out.println("------");
        System.out.println(MotoWidth);
        System.out.println(PositionX + (MotoWidth / 2));
        System.out.println("------");
        System.out.println(PanelImage.getHeight() / 2);*/

        switch ((int) rotate){
            case 0:
                return (getPositionY() + PanelImage.getWidth() /2);
            case 1:
                return (getPositionY() + PanelImage.getWidth() /2);
            case 2:
                return (getPositionY() + PanelImage.getHeight() /2);
            case 3:
                return (getPositionY() + PanelImage.getHeight() /2);
        }
        return PositionY;
    }

    public double getPositionTrainerX() {
        /*System.out.println("------");
        System.out.println(MotoWidth);
        System.out.println(PositionX + (MotoWidth / 2));
        System.out.println("------");
        System.out.println(PanelImage.getHeight() / 2);*/

        switch ((int) rotate){
            case 0:
                return (getPositionX() + PanelImage.getWidth() /2);
            case 1:
                return (getPositionX() + PanelImage.getWidth() /2);
            case 2:
                return (getPositionX() + PanelImage.getHeight() /2);
            case 3:
                return (getPositionX() + PanelImage.getHeight() /2);
        }
        return PositionX;
    }

    @Override
    public void addLastCoord() {
        System.out.println("Ajout de coordonée");
        Tcoords.get(Tcoords.size() - 1).add(getPositionTrainerX());
        Tcoords.get(Tcoords.size() - 1).add(getPositionTrainerY());
        System.out.println("J'ajoute le rotate : " + rotate);
        Tcoords.add(new ArrayList<>(Arrays.asList(rotate, getPositionTrainerX(), getPositionTrainerY())));
    }

    @Override
    public int getHeight() {
        return MotoHeight;
    }

    @Override
    public int getWidth() {
        return MotoWidth;
    }
}

package App;

import java.util.ArrayList;
import java.util.Arrays;

public class Camion extends Vehicule{
    private int CamionHeight = 40;
    private int CamionWidth = 40;
    public Camion(int PositionX, int PositionY, int PtsVieBase, int PtsVie, String LienImage,double vitesse, double VitesseTrainee) {
        super(PositionX, PositionY, PtsVieBase, PtsVie, LienImage,vitesse,VitesseTrainee);
    }

    @Override
    public double getPositionTrainerY() {
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
        Tcoords.get(Tcoords.size() - 1).add(getPositionTrainerX());
        Tcoords.get(Tcoords.size() - 1).add(getPositionTrainerY());
        Tcoords.add(new ArrayList<>(Arrays.asList(rotate, getPositionTrainerX(), getPositionTrainerY())));
    }

    @Override
    public int getHeight() {
        return CamionHeight;
    }


    @Override
    public int getWidth() {
        return CamionWidth;
    }

    @Override
    public int getLargeur(){
        return 3;
    }
}

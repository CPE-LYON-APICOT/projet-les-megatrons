package App;

import javafx.scene.layout.Pane;

import java.util.List;

public interface VehiculeInterface {
    double getPositionX();
    double getPositionY();
    int getPtsVie();
    void setPtsVie(int ptsVie);
    int getPtsVieBase();
    void setPtsVieBase(int ptsVieBase);
    Pane getPanelImage();
    void setPanelImage(Pane panelImage);
    double getRotate();
    void setRotate(double rotate);
    int getWidth();
    int getHeight();
    double getVitesseTrainee();
    double getVitesse();
    void setVitesse(double vitesse);
}
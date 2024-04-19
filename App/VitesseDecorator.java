package App;

import javafx.scene.layout.Pane;

public class VitesseDecorator extends VehiculeDecorator  {
    private int bonusVitesse;

    public VitesseDecorator(VehiculeInterface vehicule, int bonusVitesse, int duration) {
        super(vehicule);
        this.bonusVitesse = bonusVitesse;
    }

    @Override
    public double getVitesseTrainee() {
        return vehicule.getVitesseTrainee() + bonusVitesse;
    }

    @Override
    public double getVitesse() {
         return vehicule.getVitesse() + bonusVitesse;
    }
    @Override
    public void setVitesse(double vitesse) {

    }

    @Override
    public int getPtsVieBase() {
        return 0;
    }

    @Override
    public void setPtsVieBase(int ptsVieBase) {

    }

    @Override
    public Pane getPanelImage() {
        return null;
    }

    @Override
    public void setPanelImage(Pane panelImage) {

    }

    @Override
    public double getRotate() {
        return 0;
    }

    @Override
    public void setRotate(double rotate) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
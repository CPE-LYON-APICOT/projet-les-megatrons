package App;

import javafx.scene.layout.Pane;

public class InvincibiliteDecorator extends VehiculeDecorator  {
    private int bonusPv;

    public InvincibiliteDecorator(VehiculeInterface vehicule, int bonusPv, int duration) {
        super(vehicule);
        this.bonusPv = bonusPv;
    }

    public int getPtsVie() {
        return vehicule.getPtsVie() + bonusPv;
    }

    public void setPtsVie(int ptsVie) {

    }
    @Override
    public double getVitesseTrainee() {
        return vehicule.getVitesseTrainee();
    }

    @Override
    public double getVitesse() {
        return vehicule.getVitesse();
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
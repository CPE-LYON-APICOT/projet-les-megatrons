package App;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;


public abstract class Vehicule implements VehiculeInterface{
    protected double PositionX;
    protected double vitesse ;
    protected double PositionY;
    protected int PtsVieBase;
    protected int PtsVie;
    protected Pane PanelImage;
    protected double rotate = -1.0;
    private double VitesseTrainee;
    protected List<List<Double>> Tcoords = new ArrayList<List<Double>>();
    private int angle = 0;
    protected String SourcePNG;

    public Vehicule(double PositionX, double PositionY, int PtsVieBase, int PtsVie, String LienImage,double vitesse, double VitesseTrainee) {
        this.PositionX = PositionX;
        this.PositionY = PositionY;
        this.PtsVieBase = PtsVieBase;
        this.PtsVie = PtsVie;
        this.SourcePNG = LienImage;
        this.VitesseTrainee = VitesseTrainee;
        this.vitesse = vitesse;
    }

    public Vehicule(){

    }


    public void addLastCoord() {
    }

    public double getVitesseTrainee() {
        return VitesseTrainee;
    }

    public double getVitesse() {
        return vitesse;
    }
    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }
    public double getRotate() {
        return this.rotate;
    }

    public void setRotate(double Rotate){
        this.rotate = Rotate;
    }

    public int getHeight(){ return 0; }

    public int getWidth(){
        return 0;
    }

    public double getPositionX() {
        return PositionX;
    }

    public void setPositionX(double positionX) {
        PositionX = positionX;
    }

    public double getPositionTrainerX() {
        return PositionY;
    };

    public double getPositionTrainerY() {
        return PositionX;
    };

    public double getPositionY() {
        return PositionY;
    }

    public void setPositionY(double positionY) {
        PositionY = positionY;
    }

    public void genCoord(){
        List<Double> Coord = new ArrayList<Double>();
        Coord.add(rotate);
        Coord.add(getPositionTrainerX());
        Coord.add(getPositionTrainerY());
        Tcoords.add(Coord);
    }

    public Pane getPanelImage() {
        return PanelImage;
    }

    public void setPanelImage(Pane panelImage) {
        PanelImage = panelImage;
    }

    public int getPtsVieBase() {
        return PtsVieBase;
    }

    public void setPtsVieBase(int ptsVieBase) {
        PtsVieBase = ptsVieBase;
    }

    public int getPtsVie() {
        return PtsVie;
    }

    public void setPtsVie(int ptsVie) {
        PtsVie = ptsVie;
    }

    public int getLargeur(){
        return 0;
    }

    public void syncImage() {
        switch ((int) rotate){
            case 0:
                PanelImage.setRotate(180);
                break;
            case 1:
                PanelImage.setRotate(360);
                break;
            case 2:
                PanelImage.setRotate(90);
                break;
            case 3:
                PanelImage.setRotate(260);
                break;
        }
    }
}

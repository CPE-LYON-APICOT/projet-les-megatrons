package App;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.List;


public class ControllerVehicule implements IVitesse {
    private Vehicule vehicule;
    private Scene scene;
    private Pane panel;
    private String Couleur;
    public ControllerVehicule(Vehicule vehicule, Scene scene, Pane panel) {
        this.vehicule = vehicule;
        this.scene = scene;
        this.panel = panel;
    }

    public void detectCollision(List<List<Double>> Listes, double vehiculeX, double vehiculeY){
        if (Listes.size() > 1) {
            for (int i = 0; i < Listes.size() - 1; i++) {
                List<Double> liste = Listes.get(i);
                Line line = new Line(liste.get(1), liste.get(2), liste.get(3), liste.get(4));
                if (line.getBoundsInParent().intersects(vehicule.getPanelImage().getBoundsInParent())) {
                    vehicule.retirerPtsVie(1);
                    System.out.println("J'ai pris des dégats");
                }
            }
            Line line = new Line(Listes.get(Listes.size() - 1).get(1), Listes.get(Listes.size() - 1).get(2), vehiculeX, vehiculeY);
            if (line.getBoundsInParent().intersects(vehicule.getPanelImage().getBoundsInParent())) {
                vehicule.retirerPtsVie(1);
                System.out.println("J'ai pris des dégats");
            }
        }else {
            Line line = new Line(Listes.get(Listes.size() - 1).get(1), Listes.get(Listes.size() - 1).get(2), vehiculeX, vehiculeY);
            if (line.getBoundsInParent().intersects(vehicule.getPanelImage().getBoundsInParent())) {
                vehicule.retirerPtsVie(1);
                System.out.println("J'ai pris des dégats");
            }
        }
    }

    public double getVehiculeX(){
        return vehicule.getPositionX();
    }

    public double getVehiculeY(){
        return vehicule.getPositionY();
    }

    public List<List<Double>> getVehiculeTcoord(){
        return vehicule.Tcoords;
    }

    public void MoveX(double addX){
        vehicule.PositionX = vehicule.PositionX + addX;
        vehicule.PanelImage.setLayoutX(vehicule.PositionX);
    }

    public void MoveY(double addY){
        vehicule.PositionY = vehicule.PositionY + addY;
        vehicule.PanelImage.setLayoutY(vehicule.PositionY);
    }

    public void drawLine() {
        // System.out.println(vehicule.Tcoords.size());
        if (vehicule.getRotate() != -1) {
            if (vehicule.Tcoords.size() >= 1) {
                for (int i = 0; i < vehicule.Tcoords.size() - 1; i++) {
                    Line line = new Line(vehicule.Tcoords.get(i).get(1), vehicule.Tcoords.get(i).get(2), vehicule.Tcoords.get(i).get(3), vehicule.Tcoords.get(i).get(4));
                    line.setStroke(Color.web(Couleur));
                    line.setStrokeWidth(vehicule.getLargeur());
                    panel.getChildren().add(line);
                }
            }
            if (vehicule.Tcoords.size() > 0) {
                Line line = new Line(vehicule.Tcoords.get(vehicule.Tcoords.size() - 1).get(1),
                vehicule.Tcoords.get(vehicule.Tcoords.size() - 1).get(2), vehicule.getPositionTrainerX(),
                vehicule.getPositionTrainerY());
                line.setStroke(Color.web(Couleur));
                line.setStrokeWidth(vehicule.getLargeur());
                panel.getChildren().add(line);
            }
            syncTList();
        }
    }

    public boolean isDead(){
        if(vehicule.getPtsVie() <= 0){
            return true;
        };
        return false;
    }

    public void syncTList() {
        if (vehicule.Tcoords.size() > 1) {
            double v = (double) vehicule.Tcoords.get(0).get(0);
            if (v == 0.0) {
                vehicule.Tcoords.get(0).set(2, vehicule.Tcoords.get(0).get(2) - vehicule.getVitesseTrainee());
                if (vehicule.Tcoords.get(0).get(2) - vehicule.Tcoords.get(0).get(4) < 0) {
                    vehicule.Tcoords.remove(0);
                    //System.out.println("J'ai remove A");
                }
            } else if (v == 1.0) {
                vehicule.Tcoords.get(0).set(2, vehicule.Tcoords.get(0).get(2) + vehicule.getVitesseTrainee());
                if (vehicule.Tcoords.get(0).get(4) - vehicule.Tcoords.get(0).get(2) < 0) {
                    vehicule.Tcoords.remove(0);
                }
            } else if (v == 2.0) {
                vehicule.Tcoords.get(0).set(1, vehicule.Tcoords.get(0).get(1) - vehicule.getVitesseTrainee());
                if (vehicule.Tcoords.get(0).get(1) - vehicule.Tcoords.get(0).get(3) < 0) {
                    vehicule.Tcoords.remove(0);

                }
            } else if (v == 3.0) {
                vehicule.Tcoords.get(0).set(1, vehicule.Tcoords.get(0).get(1) + vehicule.getVitesseTrainee());
                if (vehicule.Tcoords.get(0).get(3) - vehicule.Tcoords.get(0).get(1) < 0) {
                    vehicule.Tcoords.remove(0);
                }
            } else if (v == -1.0) {
                vehicule.Tcoords.remove(0);
            }
        } else {
            double v = (double) vehicule.Tcoords.get(0).get(0);
            if (v == 0.0) {
                vehicule.Tcoords.get(0).set(2, vehicule.Tcoords.get(0).get(2) - vehicule.getVitesseTrainee());
            } else if (v == 1.0) {
                vehicule.Tcoords.get(0).set(2, vehicule.Tcoords.get(0).get(2) + vehicule.getVitesseTrainee());
            } else if (v == 2.0) {
                vehicule.Tcoords.get(0).set(1, vehicule.Tcoords.get(0).get(1) - vehicule.getVitesseTrainee());
            } else if (v == 3.0) {
                vehicule.Tcoords.get(0).set(1, vehicule.Tcoords.get(0).get(1) + vehicule.getVitesseTrainee());
            }
        }
    }

    public void clear() {
        panel.getChildren().clear();
    }

    public void setRotate(double Rotate){
        vehicule.setRotate(Rotate);
        vehicule.addLastCoord();
        vehicule.syncImage();
    }

    public void Spawn(Scene scene) {
        Image image = new Image(vehicule.SourcePNG);
        ImageView Joueur = new ImageView(image);
        Joueur.setFitHeight(vehicule.getHeight());
        Joueur.setFitWidth(vehicule.getWidth());
        vehicule.PanelImage = new Pane(Joueur);
        vehicule.PanelImage.setPrefHeight(vehicule.getHeight());
        vehicule.PanelImage.setPrefWidth(vehicule.getWidth());
        vehicule.PanelImage.setLayoutX(vehicule.PositionX);
        vehicule.PanelImage.setLayoutY(vehicule.PositionY);
        //vehicule.PanelImage.setStyle("-fx-background-color: #ffffff69; -fx-border-radius: 12px;");
        ((Pane) scene.getRoot()).getChildren().add(vehicule.PanelImage);
        vehicule.genCoord();
    }

    public Pane getPane() {
        return vehicule.getPanelImage();
    }

    public void retirerPtsVie(int i){
        vehicule.retirerPtsVie(i);
    }

    public void setPane(Pane panelImage) {
        vehicule.PanelImage = panelImage;
    }

    public void setCouleur(String couleur) {
        Couleur = couleur;
    }



    public void setvehiculeX(double newX) {
        vehicule.setPositionX(newX);
    }

    public void setvehiculeY(double newY) {
        vehicule.setPositionY(newY);
    }

    public boolean getDead() {
        if (vehicule.getPtsVie() == 0){
            System.out.println("J'ai plus de vie");
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double getVitesse() {
        return vehicule.getVitesse();
    }
}
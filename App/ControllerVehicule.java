package App;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ControllerVehicule {
    private Vehicule vehicule;
    private Pane panel;
    private double lastTraine;


    public ControllerVehicule(Vehicule vehicule, Pane panel) {
        this.vehicule = vehicule;
        this.panel = panel;
    }

    public void drawLine() {
        if (vehicule.Tcoords.size() >= 1){
            for (int i = 0; i < vehicule.Tcoords.size() - 1; i++) {
                Line line = new Line(vehicule.Tcoords.get(i).get(1), vehicule.Tcoords.get(i).get(2), vehicule.Tcoords.get(i).get(3), vehicule.Tcoords.get(i).get(4));
                line.setStroke(Color.web("#2ddff3"));
                panel.getChildren().add(line);
            }
        }
        Line line = new Line(vehicule.Tcoords.get(vehicule.Tcoords.size() - 1).get(1), vehicule.Tcoords.get(vehicule.Tcoords.size() - 1).get(2), vehicule.getPositionX(), vehicule.getPositionY());
        line.setStroke(Color.web("#2ddff3"));
        panel.getChildren().add(line);
        syncTList();
    }

    public void syncTList(){
        //System.out.println("Synchronisation");
        //System.out.println(vehicule.Tcoords);
        if (vehicule.Tcoords.size() > 1){
            //System.out.println("Plusieurs élément");
            double v = (double) vehicule.Tcoords.get(0).get(0);
            if (v == 0.0) {
                vehicule.Tcoords.get(0).set(1, vehicule.Tcoords.get(0).get(1) - vehicule.getVitesseTrainee());
                //System.out.println(vehicule.Tcoords.get(0).get(2) - vehicule.Tcoords.get(0).get(4));
                if(vehicule.Tcoords.get(0).get(2) - vehicule.Tcoords.get(0).get(4) < 0){
                    vehicule.Tcoords.remove(0);
                }
            } else if (v == 1.0) {
                vehicule.Tcoords.get(0).set(1, vehicule.Tcoords.get(0).get(1) + vehicule.getVitesseTrainee());
                if(vehicule.Tcoords.get(0).get(4) - vehicule.Tcoords.get(0).get(2) < 0){
                    vehicule.Tcoords.remove(0);
                }
            } else if (v == 2.0) {
                vehicule.Tcoords.get(0).set(1, vehicule.Tcoords.get(0).get(2) + vehicule.getVitesseTrainee());
                if(vehicule.Tcoords.get(0).get(3) - vehicule.Tcoords.get(0).get(1) < 0){
                    vehicule.Tcoords.remove(0);
                }
            } else if (v == 3.0) {
                vehicule.Tcoords.get(0).set(1, vehicule.Tcoords.get(0).get(2) - vehicule.getVitesseTrainee());
                if(vehicule.Tcoords.get(0).get(2) - vehicule.Tcoords.get(0).get(3)< 0){
                    vehicule.Tcoords.remove(0);
                }
            }
        }
        else {
            //System.out.println("un élément");
            double v = (double) vehicule.Tcoords.get(0).get(0);
            //System.out.println(v);
            if (v == 0.0) {
                /*System.out.println("On diminue le y de :");
                System.out.println(vehicule.Tcoords.get(0).get(2));
                System.out.println(" - ");
                System.out.println(vehicule.getVitesseTrainee());*/
                vehicule.Tcoords.get(0).set(2, vehicule.Tcoords.get(0).get(2) - vehicule.getVitesseTrainee());
                if(vehicule.Tcoords.get(0).get(2) - vehicule.getPositionY() < 0){
                    vehicule.Tcoords.remove(0);
                }
            } else if (v == 1.0) {
                vehicule.Tcoords.get(0).set(2, vehicule.Tcoords.get(0).get(2) + vehicule.getVitesseTrainee());
                if(vehicule.getPositionY() - vehicule.Tcoords.get(0).get(2) < 0){
                    vehicule.Tcoords.remove(0);
                }
            } else if (v == 2.0) {
                vehicule.Tcoords.get(0).set(2, vehicule.Tcoords.get(0).get(1) + vehicule.getVitesseTrainee());
                if(vehicule.getPositionX() - vehicule.Tcoords.get(0).get(1) < 0){
                    vehicule.Tcoords.remove(0);
                }
            } else if (v == 3.0) {
                vehicule.Tcoords.get(0).set(2, vehicule.Tcoords.get(0).get(1) - vehicule.getVitesseTrainee());
                if(vehicule.Tcoords.get(0).get(2) - vehicule.getPositionY()< 0){
                    vehicule.Tcoords.remove(0);
                }
            }
        }


    }

    public void clear(){
        System.out.println("clear");
        panel.getChildren().clear();
    }

    public void clearTList(){

    }

    public void setRotate(double rotate){
        vehicule.setRotate(rotate);
    }
}
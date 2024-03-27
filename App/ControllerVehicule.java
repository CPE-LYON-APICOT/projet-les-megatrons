package App;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import java.util.List;


public class ControllerVehicule {
    private Vehicule vehicule;
    private Pane panel;
    private int lastTraine;

    public ControllerVehicule(Vehicule vehicule, Pane panel) {
        this.vehicule = vehicule;
        this.panel = panel;
    }

    public void drawLine(){
        for (int i = 0; i < vehicule.Tcoords.size() - 1; i++) {
            //System.out.println(vehicule.Tcoords.get(i));
            Line line = new Line(vehicule.Tcoords.get(i).get(0), vehicule.Tcoords.get(i).get(1), vehicule.Tcoords.get(i).get(2), vehicule.Tcoords.get(i).get(3));
            line.setStroke(Color.web("#2ddff3"));
            panel.getChildren().add(line);
        }
        vehicule.Tcoords.get(vehicule.Tcoords.size() - 1);
        Line line = new Line(vehicule.Tcoords.get(vehicule.Tcoords.size() - 1).get(0), vehicule.Tcoords.get(vehicule.Tcoords.size() - 1).get(1), vehicule.getPositionX(), vehicule.getPositionY());
        line.setStroke(Color.web("#2ddff3"));
        panel.getChildren().add(line);
    }

    public void checkListTrainee(){
        if (vehicule.Tcoords.get(0).get(0) == vehicule.Tcoords.get(0).get(2)){
            if (vehicule.Tcoords.get(0).get(0) < vehicule.Tcoords.get(0).get(2)){
                vehicule.Tcoords.get(0).get(0) +

            }
        }
        vehicule.Tcoords.get(0);
    }

    public void syncTrainee(){

    }

    public void clear(){
        panel.getChildren().clear();
    }

    public void start(){
        if(vehicule.Tcoords.get(0).get(0) < vehicule.Tcoords.get(0).get(2)){
            lastTraine = vehicule.Tcoords.get(0).get(2) - vehicule.Tcoords.get(0).get(0);
        }else{
            lastTraine = vehicule.Tcoords.get(0).get(0) - vehicule.Tcoords.get(0).get(2);
        }
    }

}

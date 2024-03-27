package App;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class createVehicule {
    public Vehicule createVehicule(String vehicule) {
        switch (vehicule){
            case "Moto":
                return new Moto(100,100,1,1,50,new Rectangle(50,10, Color.BLUE));
                break;
        }
    }
}

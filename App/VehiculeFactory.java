package App;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VehiculeFactory {
    public VehiculeFactory() {
    }

    public Vehicule CreateVehicule(VehiculeType vehicule) {
        return switch (vehicule) {
            case VehiculeType.MOTO -> new Moto(200, 200, 1, 1, 50, new Rectangle(50, 10, Color.web("#2ddff3")), 2);
            case VehiculeType.VOITURE -> null;
            case CAMION -> null;
            default -> null;
        };
    }
}

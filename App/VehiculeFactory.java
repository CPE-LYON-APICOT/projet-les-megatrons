package App;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VehiculeFactory {
    public VehiculeFactory() {
    }

    public Vehicule CreateVehicule(VehiculeType vehicule) {
        return switch (vehicule) {
            case VehiculeType.MOTO -> new Moto(350, 250, 10, 2, "file:assets/MiddleShip.png", 3.0);
            case VehiculeType.VOITURE -> new Voiture();
            case VehiculeType.CAMION -> new Camion();
            default -> null;
        };
    }
}

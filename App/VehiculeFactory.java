package App;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VehiculeFactory {
    public VehiculeFactory() {
    }

    public Vehicule CreateVehicule(VehiculeType vehicule) {
        return switch (vehicule) {
            case VehiculeType.MOTO -> new Moto(350, 250, 10, 1, "file:assets/LowShip.png", 5.0,4.0);
            case VehiculeType.VOITURE -> new Voiture(350, 250, 10, 1, "file:assets/MiddleShip.png", 4.0, 3.0);
            case VehiculeType.CAMION -> new Camion(350, 250, 10, 1, "file:assets/BigShip.png", 3.0, 1.0);
            default -> null;
        };
    }
}

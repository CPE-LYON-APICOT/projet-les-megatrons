package App;

public class InvincibiliteDecorator extends VehiculeDecorator implements IPointsDeVie {

    public InvincibiliteDecorator(Vehicule vehicule) {
        this.baseProvider = vehicule.multiplicateurDegat;
    }

    @Override
    public int getMultiplicateur() {
        return 0;
    }
}
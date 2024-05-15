package App;

public class InvincibiliteDecorator extends VehiculeDecorator implements IPointsDeVie {
    protected IPointsDeVie multiplicateur;

    public InvincibiliteDecorator(Vehicule vehicule) {
        this.multiplicateur = vehicule.multiplicateurDegat;
    }

    @Override
    public int getMultiplicateur() {
        return 0;
    }
}
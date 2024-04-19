package App;

public abstract class VehiculeDecorator implements VehiculeInterface {
    protected VehiculeInterface vehicule;

    public VehiculeDecorator(VehiculeInterface vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public double getPositionX() {
        return vehicule.getPositionX();
    }

    @Override
    public double getPositionY() {
        return vehicule.getPositionY();
    }

    @Override
    public int getPtsVie() {
        return vehicule.getPtsVie();
    }

    @Override
    public void setPtsVie(int ptsVie) {
        vehicule.setPtsVie(ptsVie);
    }

}

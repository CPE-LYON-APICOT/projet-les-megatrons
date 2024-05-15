package App;

public class VitesseDecorator extends VehiculeDecorator implements IVitesse {




    public VitesseDecorator(Vehicule vehicule) {
        baseProvider =vehicule.vitesseProvider;
    }


    @Override
    public double getVitesse() {
         return ((IVitesse) baseProvider).getVitesse() + 5;
    }

    public IVitesse getBasedProvider() {
        return (IVitesse) baseProvider;
    }
}
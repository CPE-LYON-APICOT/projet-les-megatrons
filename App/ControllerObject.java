package App;

import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.*;

public class ControllerObject {
    protected List<Object> Objects = new ArrayList<Object>();
    protected List<Vehicule> Vehicules = new ArrayList<Vehicule>();

    protected long lastSpawn;

    public ControllerObject(Vehicule Joueur1, Vehicule Joueur2) {
        Vehicules.add(Joueur1);
        Vehicules.add(Joueur2);
    }

    public void spawnUnObjet(Scene scene) {
        Random random = new Random();
        double positionY = random.nextInt((int) 700);
        double positionX = random.nextInt((int) 1000);

        Object object = new InvincibilityBuilder().setSprite("file:assets/skillicon11_04.png").setX(positionX).setY(positionY).setDuration(5).setPvBonus(9999).build();
        String LienImage = "file:assets/skillicon11_04.png";
        switch (random.nextInt(0,2)) {
            case 0 :
                object = new InvincibilityBuilder().setSprite("file:assets/skillicon11_04.png").setX(positionX).setY(positionY).setDuration(5).setPvBonus(9999).build();
                LienImage = "file:assets/skillicon11_04.png";
                System.out.println("Tirer 0");
                break;
            case 1:
                object = new VitesseBuilder().setSprite("file:assets/skillicon11_29.png").setX(positionX).setY(positionY).setDuration(5).setBonusVitesse(5).build();
                LienImage = "file:assets/skillicon11_29.png";
                System.out.println("Tirer 1");
                break;
        };
        Image image = new Image(LienImage);
        ImageView objet = new ImageView(image);
        objet.setFitHeight(50);
        objet.setFitWidth(50);

        object.PanelImage = new Pane(objet);
        object.PanelImage.setPrefHeight(50);
        object.PanelImage.setPrefWidth(50);
        object.PanelImage.setLayoutX(positionX);
        object.PanelImage.setLayoutY(positionY);

        this.Objects.add(object);
        ((Pane) scene.getRoot()).getChildren().add(object.PanelImage);
        this.lastSpawn = System.currentTimeMillis();
    }

    public boolean isObjectSpawnable() {
        if (System.currentTimeMillis() - this.lastSpawn > 15000){
            this.lastSpawn = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public boolean isVehiculeOn(Vehicule vehicule, Scene scene){
        if (Objects.isEmpty()){
        }else{
            List<Integer> intToSupp = new ArrayList<Integer>();
            for (Object obj: Objects) {
                Bounds boundObject = obj.getPanelImage().getBoundsInParent();
                Bounds boundVehicule = vehicule.getPanelImage().getBoundsInParent();
                if (boundVehicule.intersects(boundObject) && obj.isUse() == false){
                    obj.setUse(true);
                    applyObject(vehicule, obj);
                    ((Pane) scene.getRoot()).getChildren().remove(obj.PanelImage);
                    intToSupp.add(Objects.indexOf(obj));
                    return true;
                }
            }
            if (intToSupp.isEmpty() == false){
                for (int i = intToSupp.size() - 1; i >= 0; i--) {
                    Objects.remove(Objects.get(intToSupp.get(i)));
                }
            }
        }
        return false;
    }


    public Vehicule applyObject(Vehicule vehicule, Object object) {
        Timer timer = new Timer();
        long delaySpeed = 5000;
        long delayInvincibility = 3000;

        switch (object.getType()) {

            case INVICIBILITE:
                Invicibilite invicibilite = (Invicibilite) object;
                InvincibiliteDecorator invicibiliteDecorator = new InvincibiliteDecorator(vehicule);
                vehicule.multiplicateurDegat = new InvincibiliteDecorator(vehicule);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        vehicule.multiplicateurDegat = (IPointsDeVie) invicibiliteDecorator.baseProvider;
                    }
                }, delayInvincibility);
                break;

            case VITESSE:
                VitesseDecorator vitesseDecorator = new VitesseDecorator(vehicule);
                vehicule.setVitesseProvider(vitesseDecorator);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        vehicule.setVitesseProvider(vitesseDecorator.getBasedProvider());
                    }
                }, delaySpeed);
                break;

            default:
                break;
        }
        return vehicule;
    }
}

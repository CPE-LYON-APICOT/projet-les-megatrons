package App;

import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.lang.Thread;


public class ControllerObject {
    protected List<Object> Objects = new ArrayList<Object>();

    //protected List<Vehicule> VehiculesBase = new ArrayList<Vehicule>();
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
        switch (random.nextInt(0, 2)) {
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
        System.out.println(System.currentTimeMillis() - this.lastSpawn);
        //20000
        if (System.currentTimeMillis() - this.lastSpawn > 5000){
            this.lastSpawn = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public void isVehiculeOn(Vehicule vehicule, Scene scene){
        if (Objects.isEmpty()){
        }else{
            List<Integer> intToSupp = new ArrayList<Integer>();
            for (Object obj: Objects) {
                Bounds boundObject = obj.getPanelImage().getBoundsInParent();
                Bounds boundVehicule = vehicule.getPanelImage().getBoundsInParent();
                if (boundVehicule.intersects(boundObject)){
                    System.out.println("Je touche un bonus");
                    applyObject(vehicule, obj);
                    ((Pane) scene.getRoot()).getChildren().remove(obj.PanelImage);
                    intToSupp.add(Objects.indexOf(obj));
                }
            }
            if (intToSupp.isEmpty() == false){
                for (int i = intToSupp.size() - 1; i >= 0; i--) {
                    Objects.remove(Objects.get(intToSupp.get(i)));
                }
            }
        }
    }


    public Vehicule applyObject(VehiculeInterface vehicule, Object object) {
        //Vehicules.set(VehiculesBase.indexOf(vehicule), (Vehicule) vehicule);
        switch (object.getType()) {
            case INVICIBILITE:
                Invicibilite invicibilite = (Invicibilite) object;
                InvincibiliteDecorator invicibiliteDecorator = new InvincibiliteDecorator(vehicule, invicibilite.getPvBonus(), invicibilite.getDuration());
                System.out.println("J'ai pris un bonus d'invincibilité ");
                vehicule = invicibiliteDecorator;
                vehicule.setVitesse(90);
                return (Vehicule) vehicule;
            case VITESSE:
                Vitesse vitesse = (Vitesse) object;
                VitesseDecorator vitesseDecorator = new VitesseDecorator(vehicule, vitesse.getBonusvitesse(), vitesse.getDuration());
                System.out.println("J'ai pris un bonus de vitesse");
                vehicule = vitesseDecorator;
                return (Vehicule) vehicule;
            default:
                break;
        }
        return null;
    }
}

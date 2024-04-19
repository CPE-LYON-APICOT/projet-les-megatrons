package App;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.Random;
import java.lang.Thread;


public class ControllerObject {

    private Vehicule vehicule;
    public ControllerObject(Vehicule vehicule) {
        this.vehicule = vehicule;
    }



    public Invicibilite objectInvicibilite(Pane pane){
        Random random = new Random();
        //System.out.println(pane.getHeight());
        double positionY = random.nextInt((int) pane.getHeight());
        double positionX = random.nextInt((int) pane.getWidth()) ;
        Invicibilite objInvicibilite = new InvincibilityBuilder()
                .setSprite(new ImageView(new Image("file:assets/skillicon11_04.png")))
                .setX(positionX)
                .setY(positionY)
                .setDuration(5)
                .setPvBonus(9999)
                .build();
        return  objInvicibilite;
    }

    public Vitesse objectVitesse(Pane pane){
        Random random = new Random();
        //System.out.println(pane.getHeight());
        double positionY = random.nextInt((int) pane.getHeight());
        double positionX = random.nextInt((int) pane.getWidth()) ;
        Vitesse objectVitesse = new VitesseBuilder()
                .setSprite(new ImageView(new Image("file:assets/skillicon11_05.png")))
                .setX(positionX)
                .setY(positionY)
                .setDuration(5)
                .setBonusVitesse(5)
                .build();

        return  objectVitesse;
    }



    public void placeObject(Pane pane, Object object){

        pane.getChildren().add(object.getPane());
    }

    public void useObject (Pane pane, Object object) throws InterruptedException {

        System.out.println(pane.getChildren());
        //TODO remettre quand hitbox sera fixé
        //pane.getChildren().remove(object.getPane());

        switch (object.getType()){
            case INVICIBILITE -> useInvicibilite((Invicibilite) object);
            case VITESSE -> useVitesse();

        }
    }

    public  void useInvicibilite(Invicibilite objInvicibilite) throws InterruptedException {
        System.out.println("l'objet invicibilité est utilisé ");
        int pvDebut = vehicule.getPtsVie();
        vehicule.setPtsVie(objInvicibilite.getPvBonus());
        System.out.println("PVDEbut"+vehicule.getPtsVie());
        //wait();
        //
        Thread invicibiliteThread = new Thread(() -> {
            try {
                //System.out.println("Invincibilité activée !");
                Thread.sleep(objInvicibilite.getDuration()*1000); // Attendre 5 secondes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fin de l'invincibilité normalement");
            vehicule.setPtsVie(vehicule.getPtsVieBase());
        });
        invicibiliteThread.start();

    }
    public void useVitesse(){
        System.out.println("l'objet vitesse est utilisé ");
        //TODO A finir quand la vitesse sera mise dans le vehicule :/

    }
}

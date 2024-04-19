package App;

import javafx.scene.image.ImageView;

public class InvincibilityBuilder {
    private ImageView sprite;
    private double x;
    private double y;
    private int duration;
    private int pvBonus;

    public InvincibilityBuilder setSprite(ImageView sprite) {
        this.sprite = sprite;
        return this;
    }

    public InvincibilityBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public InvincibilityBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public InvincibilityBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public InvincibilityBuilder setPvBonus(int pvBonus) {
        this.pvBonus = pvBonus;
        return this;
    }

    public Invicibilite build() {
        Invicibilite invicibilite = new Invicibilite(sprite, x, y);
        invicibilite.setDuration(duration);
        invicibilite.setPvBonus(pvBonus);
        return invicibilite;
    }
}


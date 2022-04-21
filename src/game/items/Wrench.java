package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Wrench extends WeaponItem{
    int price;

    public Wrench() {
        super("Wrench", '/', 50, "smacks", 80);
    }
}

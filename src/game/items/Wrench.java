package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Wrench extends WeaponItem implements Purchasable{

    public Wrench() {
        super("Wrench", '/', 50, "smacks", 80);
    }

    @Override
    public int price() {
        return 200;
    }
}

package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Status;

public class Wrench extends WeaponItem implements Purchasable{

    public Wrench() {
        super("Wrench", '/', 50, "smacks", 80);
        this.addCapability(Status.WRENCH);
    }

    /**
     * Adds item to the actor after purchasable item
     * @param actor The actor receiving the purchasable item
     */
    @Override
    public void add_item(Actor actor) {
        actor.addItemToInventory(this);
    }
}

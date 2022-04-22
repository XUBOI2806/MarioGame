package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Status;

public class Wrench extends WeaponItem implements Purchasable{

    public Wrench() {
        super("Wrench", '/', 50, "smacks", 80);
        this.addCapability(Status.WRENCH);
    }

    public PickUpItemAction getPickUpAction(Actor actor) {
        actor.addCapability(Status.WRENCH);
        return super.getPickUpAction(actor);
    }

    @Override
    public int price() {
        return 200;

}

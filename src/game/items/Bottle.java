package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actors.Status;



/**
 * Class representing the item Bottle.
 */
public class Bottle extends Item implements ObtainAble{

    /**
     * Constructor.
     *
     */
    public Bottle() {
        super("Bottle", 'B', Boolean.parseBoolean("False"));
    }

    @Override
    public String obtainedBy(Actor actor, Actor target) {
        target.removeItemFromInventory(this);
        target.removeCapability(Status.HAS_BOTTLE);
        actor.addItemToInventory(this);
        actor.addCapability(Status.HAS_BOTTLE);
        return actor + "obtained bottle";
    }


}

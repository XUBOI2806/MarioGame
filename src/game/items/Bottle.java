package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.FillBottleAction;
import game.actors.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


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
        this.addCapability(Status.HAS_BOTTLE);
    }

    @Override
    public String obtainedBy(Actor actor) {
        return actor + "obtained bottle";
    }


}

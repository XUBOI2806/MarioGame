package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actors.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * A fire flower consumable item
 */
public class FireFlower extends Item implements ConsumeAble {

    private ConsumeAction consume;
    private int age = 0;

    /***
     * Constructor.
     * Adds a new consume action to the flower
     */
    public FireFlower() {
        super("Fire Flower", 'f', Boolean.parseBoolean("True"));
        this.consume = new ConsumeAction(this);
        this.addAction(consume);
    }

    /**
     * Performs the consuming of the flower
     * @param actor     The actor consuming the consumable item
     * @param map       The game map
     * @return a string describing the consumption
     */
    @Override
    public String consumedBy(Actor actor, GameMap map) {
        this.addCapability(Status.FIRE);
        this.removeAction(consume);
        this.togglePortability();
        // The case that the item is not in the actors inventory and still on the ground
        if(map.locationOf(actor).getItems().contains(this)) {
            map.locationOf(actor).removeItem(this);
            actor.addItemToInventory(this);
        }
        return actor + " ate the fire flower";
    }

    /**
     * Ticks over the age of the flower to know when to expire
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        // If the age is 20 then remove item from actor
        if(age == Utils.FIRE_FLOWER_EXPIRY){
            actor.removeItemFromInventory(this);
        }

        // Keep iterating the age
        if(this.hasCapability(Status.FIRE)){
            age++;
        }
    }
}

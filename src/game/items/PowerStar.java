package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeItemAction;
import game.actors.Status;
import edu.monash.fit2099.engine.displays.Display;
import game.grounds.Dirt;

import java.util.ArrayList;
import java.util.List;

/**
 * Power Star item that can be consumed
 */
public class PowerStar extends Item implements Purchasable, ConsumeAble {
    private int age = 0;
    private int turns_left;
    private ConsumeItemAction consume;
    private boolean consumed;

    /**
     * Constructor
     */
    public PowerStar() {
        super("Power Star", '*', Boolean.parseBoolean("True"));
        this.consume = new ConsumeItemAction(this);
        this.addAction(consume);
        this.turns_left = 11;
    }

    /**
     * Adds the power star to an actor's inventory
     * @param actor the actor to add to
     */
    public void add_item(Actor actor){
        actor.addItemToInventory(this);
    }

    /**
     * Execution of consuming the power star which heals the player and adds INVINCIBLE status.
     * @param actor
     * @return returns the description of consuming power star
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.heal(1000);
        actor.addCapability(Status.INVINCIBLE);
        this.removeAction(consume);
        this.consumed = true;
        this.togglePortability();
        return actor + " ate the power star";
    }

    /**
     * Checks the amount of turns of actor carrying item for the power star in order to expire or for INVINCIBLE status to wear off
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        age++;
        if(actor.hasCapability(Status.INVINCIBLE)){
            if(currentLocation.getGround().getDisplayChar() == '+' || currentLocation.getGround().getDisplayChar() == '#'){
                currentLocation.setGround(new Dirt());
                currentLocation.addItem(new Coin(5));
            }
            this.turns_left--;
        }
        if (age == 10 & !actor.hasCapability(Status.INVINCIBLE)) {
            actor.removeItemFromInventory(this);
        }

        if(turns_left == 0){
            actor.removeItemFromInventory(this);
            actor.removeCapability(Status.INVINCIBLE);
        }

    }

    /**
     * Checks the amount of turns on the ground
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        age++;
        if (age == 10) {
            currentLocation.removeItem(this);
        }
    }

    /**
     * String to print out for the power star
     * @return A string of the power star
     */
    @Override
    public String toString() {
        if(this.consumed == false){
            int turnsLeft = 10 - this.age;
            return super.toString() + " (" + turnsLeft + " turns left)";
        }
        return super.toString();
    }
}


package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.Coin;
import game.items.Utils;

/**
 * Abstract high ground class
 */
public abstract class HighGround extends Ground {

    /**
     * Constructor
     * @param displayChar display character
     */
    public HighGround(char displayChar){
        super(displayChar);
    }

    /**
     * If an actor has the Status INVINCIBLE or FLY then they can enter
     * @param actor the Actor to check
     * @return a boolean
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.INVINCIBLE) || actor.hasCapability(Status.FLY)) {
            return true;
        }
        return false;
    }

    /**
     * Returns a collection of possible actions an actor may take.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a collection of actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor() && location.getActor().hasCapability(Status.INVINCIBLE)){
            location.setGround(new Dirt());
            location.addItem(new Coin(Utils.DESTROYED_GROUND_VALUE));
        }
        return super.allowableActions(actor, location, direction);
    }
}

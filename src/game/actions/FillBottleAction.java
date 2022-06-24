package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.BottleManager.BottleManager;
import game.grounds.fountains.Fountain;
import game.items.Utils;

/**
 * Action for filling up bottle.
 */
public class FillBottleAction extends Action {

    /**
     * Special action for filling water from fountain
     */
    private Fountain fountain;

    /**
     * Constructor.
     * @param fountain A fountain which the water is taken from
     */
    public FillBottleAction(Fountain fountain) {
        this.fountain = fountain;
    }

    /**
     * executes to fill bottle from fountain action
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string describing the actor filling the bottle with water
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (BottleManager.getInstance().length(actor) == Utils.BOTTLE_AMOUNT){
            return "Bottle is full";
        }
        return fountain.getWater(actor);
    }

    /**
     * menu description of the actor filling the bottle up
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string describing filling the water from the fountain
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " refills bottle from " + fountain.getFountainDescription() + fountain.getCapacity();
    }
}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.BottleManager.BottleManager;
import game.items.Water;

/**
 * Action for drinking out of bottle
 */
public class DrinkWaterFromBottleAction extends Action {

    /**
     * Special action for drinking water from bottle
     */
    public DrinkWaterFromBottleAction() {
    }

    /**
     * executes to consume water from bottle action
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string describing the actor consuming the water
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Water water = BottleManager.getInstance().useWater(actor);
        if (water == null){
            return actor + " consumes nothing";
        }
        return actor + " consumes " + water.string();
    }

    /**
     * menu description of the actor consuming the water
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string describing consuming the water from the bottle
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes Bottle" + BottleManager.getInstance().returnWaterStack(actor);
    }
}

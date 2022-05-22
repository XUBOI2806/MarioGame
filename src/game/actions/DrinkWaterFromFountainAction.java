package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Drinker;
import game.grounds.fountains.Fountain;

public class DrinkWaterFromFountainAction extends Action {

    /**
     * Special action for drinking water from fountain
     */
    private Fountain fountain;

    /**
     * Constructor.
     * @param fountain A fountain which the water is consumed from
     */
    public DrinkWaterFromFountainAction(Fountain fountain) {
        this.fountain = fountain;
    }

    /**
     * executes to consume water from fountain action
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string describing the actor consuming the water
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        fountain.buff((Drinker) actor);
        return menuDescription(actor);
    }

    /**
     * menu description of the actor consuming the water
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string describing consuming the water from the fountain
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + fountain.getWaterDescription();
    }
}

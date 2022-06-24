package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Destruct action that removes actor
 */
public class DestructAction extends Action {

    /**
     * Constructor
     */
    public DestructAction() {
    }

    /**
     * Performing the destruct
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string with description
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return menuDescription(actor);
    }

    /**
     * Description of the self-destruct
     * @param actor The actor performing the action.
     * @return string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " self-explodes";
    }
}

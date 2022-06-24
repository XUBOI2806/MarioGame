package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Action that ends the game
 */
public class EndGameAction extends Action {
    private Actor target;

    /**
     * Constructor
     * @param target the actor to remove
     */
    public EndGameAction(Actor target) {
        this.target = target;
    }

    /**
     * Performing the end
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Victory message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return "Princess Peach is Saved!";
    }

    /**
     * Description of the end game action
     * @param actor The actor performing the action.
     * @return a string
     */
    @Override
    public String menuDescription(Actor actor) {
        return target + " ends the game";
    }
}

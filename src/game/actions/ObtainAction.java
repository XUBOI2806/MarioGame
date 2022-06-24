package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.ObtainAble;

/**
 * Action for obtaining an item
 */
public class ObtainAction extends Action{

    ObtainAble item;
    Actor target;

    /**
     * Constructor.
     * @param item The item to be obtained
     * @param target The actor holding the obtainable item
     */
    public ObtainAction(ObtainAble item, Actor target) {
        this.item = item;
        this.target = target;
    }

    /**
     * Executes the transition of obtaining the item.
     * The target will have the item also removed from its inventory.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        item.obtainedBy(actor, target);
        return actor + " successfully obtains " + item;
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string of the actor obtaining the item
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " obtains " + item;
    }
}

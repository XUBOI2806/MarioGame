package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;
import game.items.ObtainAble;

public class ObtainAction extends Action{

    /**
     * The item that will be obtained
     */
    ObtainAble item;

    Actor target;

    /**
     * Constructor.
     *  @param item The item to be bought
     *
     */
    public ObtainAction(ObtainAble item, Actor target) {
        this.item = item;
        this.target = target;
    }

    /**
     * Checks whether the Actor has enough balance to buy the item and if they do,
     * then the actor will receive the item in there inventory. If not, a string
     * will be displayed of the failed transaction.
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
     * @return a string, e.g. "Player picks up the rock"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " obtains " + item;
    }
}

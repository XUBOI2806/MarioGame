package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;
import game.reset.Resettable;

/**
 * An action to remove the dormant Koopa
 */
public class RemoveDormantActorAction extends Action {
    // Attributes
    /**
     * An attribute of actor that is the target
     */
    protected Actor target;

    /**
     * Direction of attack
     */
    protected String direction;

    /**
     * Constructor
     * @param target Actor that is target
     * @param direction Direction of attack as a string
     */
    public RemoveDormantActorAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * execute will remove actor and drop the items it has
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string that describes the removal of the target
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        ActionList dropActions = new ActionList();
        // drop all items
        for (Item item : target.getInventory())
            dropActions.add(item.getDropAction(actor));
        for (Action drop : dropActions)
            drop.execute(target, map);
        // remove actor
        map.removeActor(target);
        ResetManager.getInstance().cleanUp((Resettable) target);

        return menuDescription(actor);
    }

    /**
     * Menu Description of removing the dormant actor
     * @param actor The actor performing the action.
     * @return string of description
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " destroys " + target + "(dormant)";
    }
}

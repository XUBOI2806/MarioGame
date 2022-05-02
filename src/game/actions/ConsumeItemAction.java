package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.ConsumeAble;

/**
 * Special action for consuming an item
 */
public class ConsumeItemAction extends Action {
    private ConsumeAble consumeAble;

    /**
     * Constructor.
     * @param consumeAble A consumable item.
     */
    public ConsumeItemAction(ConsumeAble consumeAble) {
        this.consumeAble = consumeAble;
    }

    /**
     * executes the consume action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string describing the item consumed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return consumeAble.consumedBy(actor);
    }

    /**
     * menu description of the actor consuming the item
     * @param actor The actor performing the action.
     * @return a string describing consuming the item
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumeAble;
    }
}

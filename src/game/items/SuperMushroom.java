package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeItemAction;
import game.actors.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Super Mushroom item that is consumable.
 */
public class SuperMushroom extends Item implements Purchasable, ConsumeAble{
    int maxHPIncrease;
    public SuperMushroom() {
        super("Super Mushroom", '^', Boolean.parseBoolean("True"));
        this.maxHPIncrease = 50;
    }

    /**
     * Adds item to an actor
     * @param actor Actor to be added to
     */
    @Override
    public void add_item(Actor actor) {
        actor.addItemToInventory(this);
    }

    /**
     * Consuming the super mushroom
     * @param actor The actor consuming the super mushroom
     * @return String to describe the actor consuming super mushroom
     */
    @Override
    public String consumedBy(Actor actor){
        actor.increaseMaxHp(this.maxHPIncrease);
        actor.addCapability(Status.TALL);
        actor.removeItemFromInventory(this);
        return actor + " ate the super mushroom";
    }

    /**
     * Allowable actions of super mushroom
     * @return An ActionList of ConsumeItemAction
     */
    @Override
    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new ConsumeItemAction(this));
        return actions;
    }
}

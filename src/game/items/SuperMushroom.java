package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
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
        this.maxHPIncrease = Utils.SUPER_MUSHROOM_HP_INCREASE;
    }

    /**
     * Adds item to the actor after purchasable item
     * @param actor The actor receiving the purchasable item
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
     * @return An ActionList of ConsumeAction
     */
    @Override
    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new ConsumeAction(this));
        return actions;
    }
}




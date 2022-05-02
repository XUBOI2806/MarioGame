package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeItemAction;
import game.actors.Status;

import java.util.ArrayList;
import java.util.List;

public class SuperMushroom extends Item implements Purchasable, ConsumeAble{
    int maxHPIncrease;
    public SuperMushroom() {
        super("Super Mushroom", '^', Boolean.parseBoolean("True"));
        this.maxHPIncrease = Utils.SUPER_MUSHROOM_HP_INCREASE;
    }

    @Override
    public void add_item(Actor actor) {
        actor.addItemToInventory(this);
    }

    public int increaseHP() {
        return maxHPIncrease;
    }

    @Override
    public String consumedBy(Actor actor){
        actor.increaseMaxHp(this.increaseHP());
        actor.addCapability(Status.TALL);
        actor.removeItemFromInventory(this);
        return actor + " ate the super mushroom";
    }

    @Override
    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new ConsumeItemAction(this));
        return actions;
    }
}

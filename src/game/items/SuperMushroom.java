package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.actions.ConsumeItemAction;
import game.actors.Status;

public class SuperMushroom extends Item implements Purchasable, ConsumeAble{
    int price;
    int maxHPIncrease;
    public SuperMushroom() {
        super("Super Mushroom", '^', Boolean.parseBoolean("True"));
        this.maxHPIncrease = 50;
    }

    @Override
    public void add_item(Actor actor) {
        actor.addItemToInventory(this);
    }

    @Override
    public int increaseHP() {
        return maxHPIncrease;
    }

    @Override
    public ConsumeItemAction consumeAction(Actor actor) {
        actor.addCapability(Status.TALL);
        ConsumeItemAction consume = new ConsumeItemAction(new SuperMushroom());
        return consume;
    }



}

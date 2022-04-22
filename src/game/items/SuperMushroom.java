package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actors.Status;

public class SuperMushroom extends Item implements Purchasable, ConsumeAble{
    int price;

    public SuperMushroom() {
        super("Super Mushroom", '^', Boolean.parseBoolean("True"));
    }

    @Override
    public int price() {
        return 400;
    }

    @Override
    public Action consumeAction(Actor actor) {
        actor.addCapability(Status.TALL);
        return
    }
}

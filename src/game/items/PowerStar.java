package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeItemAction;
import game.actors.Status;

public class PowerStar extends Item implements Purchasable, ConsumeAble{
    int price;

    public PowerStar() {
        super("Power Star", '*', Boolean.parseBoolean("True"));
        this.addAction(new ConsumeItemAction(this));
    }

    @Override
    public int price() {
        return 600;
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.heal(1000);
        actor.addCapability(Status.INVINCIBLE);
        actor.removeItemFromInventory(this);
        return actor + " ate the power star";
    }
}

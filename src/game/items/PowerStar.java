package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeItemAction;
import game.actors.Status;

import java.util.ArrayList;
import java.util.List;

public class PowerStar extends Item implements Purchasable, ConsumeAble {
    int price;

    public PowerStar() {
        super("Power Star", '*', Boolean.parseBoolean("True"));
    }

    public void add_item(Actor actor){
        actor.addItemToInventory(this);
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.heal(1000);
        actor.addCapability(Status.INVINCIBLE);
        actor.removeItemFromInventory(this);
        return actor + " ate the power star";
    }

    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new ConsumeItemAction(this));
        return actions;
    }
}


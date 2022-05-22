package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.actors.Status;

import java.util.ArrayList;
import java.util.List;

public class FireFlower extends Item implements ConsumeAble {

    /***
     * Constructor.
     */
    public FireFlower() {
        super("Fire Flower", 'f', Boolean.parseBoolean("True"));
        this.addCapability(Status.FIRE);
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.heal(Utils.POWER_STAR_HP_INCREASE);
        this.addCapability(Status.INVINCIBLE);
        this.removeAction(new ConsumeAction(this));
        this.togglePortability();
        return actor + " ate the power star";
    }

    /**
     * Allowable actions of fire flower
     * @return An ActionList of ConsumeAction
     */
    @Override
    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new ConsumeAction(this));
        return actions;
    }
}

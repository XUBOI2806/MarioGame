package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.FillBottleAction;
import game.actors.Status;
import game.grounds.Fountain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Class representing the item Bottle.
 */
public class Bottle extends Item implements ObtainAble{

    private final Stack <String> stack= new Stack<>();

    /**
     * Constructor.
     *
     */
    public Bottle() {
        super("Bottle", 'B', Boolean.parseBoolean("False"));
        this.addCapability(Status.HASBOTTLE);
    }

    /**
     *
     */
    @Override
    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new FillBottleAction());
    }


    @Override
    public String obtainedBy(Actor actor) {
        return actor + "obtained bottle";
    }


}

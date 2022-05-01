package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;
import game.reset.Resettable;

import java.util.Random;

public class RemoveActorAction extends Action {
    // Attributes
    protected Actor target;
    protected String direction;
    protected Random rand = new Random();

    // Constructor
    public RemoveActorAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }
    // Methods
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " removes " + target;

        ActionList dropActions = new ActionList();
        // drop all items
        for (Item item : target.getInventory())
            dropActions.add(item.getDropAction(actor));
        for (Action drop : dropActions)
            drop.execute(target, map);
        // remove actor
        map.removeActor(target);
        ResetManager.getInstance().cleanUp((Resettable) target);
        result += System.lineSeparator() + target + " is killed.";

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " removes " + target + " at " + direction;
    }
}

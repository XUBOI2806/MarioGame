package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

public class RemoveAction extends Action {
    // Attributes
    protected Actor target;
    protected String direction;
    protected Random rand = new Random();

    // Constructor
    public RemoveAction(Actor target, String direction) {
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
        result += System.lineSeparator() + target + " is killed.";

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction;
    }
}

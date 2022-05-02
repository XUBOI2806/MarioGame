package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;
import game.reset.Resettable;

public class RemoveDormantKoopaAction extends Action {
    // Attributes
    protected Actor target;
    protected String direction;

    // Constructor
    public RemoveDormantKoopaAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }
    // Methods
    @Override
    public String execute(Actor actor, GameMap map) {

        ActionList dropActions = new ActionList();
        // drop all items
        for (Item item : target.getInventory())
            dropActions.add(item.getDropAction(actor));
        for (Action drop : dropActions)
            drop.execute(target, map);
        // remove actor
        map.removeActor(target);
        ResetManager.getInstance().cleanUp((Resettable) target);

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " destroys " + target + "(dormant)";
    }
}

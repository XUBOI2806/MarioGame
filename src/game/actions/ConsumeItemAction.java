package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.ConsumeAble;

public class ConsumeItemAction extends Action {
    private Item item;

    public ConsumeItemAction(Item item) {
        this.item = item;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(item);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "eats the " + item;
    }
}

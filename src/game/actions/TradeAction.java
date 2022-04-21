package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class TradeAction extends Action {

    /**
     * Create a class of toad
     */
    protected Actor target;
    protected Item item;

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     */
    public TradeAction(Actor target) {
        this.target = target;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        if (target.getInventory().contains());
    }

    @Override
    public String menuDescription(Actor actor) {
        for (Item item : target.getInventory()) {
            switch(item.toString()){
                case "Power Star":
                    return actor + " buys Power Star ($600)";
                case "Super Mushroom":
                    return actor + " buys Super Mushroom ($400)";
                case "Wrench":
                    return actor + " buys Wrench ($200)";
            }
        }
        return null;
    }
}
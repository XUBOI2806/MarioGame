package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class TradeWrenchAction extends Action {

    /**
     * Create a class of toad
     */
    protected Actor target;

    @Override
    public String execute(Actor actor, GameMap map) {
        if (target.getInventory().contains());
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys Wrench ($200)";
    }
}
package game.actions;

import edu.monash.fit2099.demo.conwayslife.Player;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class TradePowerStarAction extends Action {

    /**
     * Create a class of toad
     */
    protected Actor target;

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     */
    public TradePowerStarAction(Actor target) {
        this.target = target;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys Power Star ($600)";
    }
}
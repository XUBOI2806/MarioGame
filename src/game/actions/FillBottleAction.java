package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.BottleManager;
import game.grounds.Fountain;
import game.items.Utils;

public class FillBottleAction extends Action {
    private Fountain fountain;

    public FillBottleAction(Fountain fountain) {
        this.fountain = fountain;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (BottleManager.getInstance().length(actor) == Utils.BOTTLE_AMOUNT){
            return "Bottle is full";
        }
        return fountain.getWater(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " refills bottle from " + fountain.getFountainDescription() + fountain.getCapacity();
    }
}

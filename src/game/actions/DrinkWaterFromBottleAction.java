package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.BottleManager;
import game.items.Water;

public class DrinkWaterFromBottleAction extends Action {


    public DrinkWaterFromBottleAction() {
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Water water = BottleManager.getInstance().useWater(actor);
        if (water == null){
            return actor + " consumes nothing";
        }
        return actor + " consumes " + water.string();
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes Bottle" + BottleManager.getInstance().returnWaterStack(actor);
    }
}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Bottle;
import game.items.MagicalWater;

public class DrinkWaterAction extends Action {
    private MagicalWater magicalWater;
    private Bottle bottle;


    public DrinkWaterAction(MagicalWater magicalWater) {
        this.magicalWater = magicalWater;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        bottle.useBottle(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}

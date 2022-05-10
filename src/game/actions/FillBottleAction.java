package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.MagicalWater;

public class FillBottleAction extends Action {
    private MagicalWater magicalWater;

    public FillBottleAction(MagicalWater magicalWater) {
        this.magicalWater = magicalWater;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return magicalWater.fills(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}

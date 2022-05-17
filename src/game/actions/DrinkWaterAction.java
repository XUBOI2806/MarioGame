package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.Fountain;
import game.items.Bottle;
import game.items.Water;

public class DrinkWaterAction extends Action {
    private final Fountain fountain;
    private Water water;
    private Bottle bottle;


    public DrinkWaterAction(Fountain fountain) {
        this.fountain = fountain;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        fountain.buff(actor);
        return this.menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + fountain.getDescription();
    }
}

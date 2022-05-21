package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Drinker;
import game.grounds.fountains.Fountain;

public class DrinkWaterFromFountainAction extends Action {

    private Fountain fountain;

    public DrinkWaterFromFountainAction(Fountain fountain) {
        this.fountain = fountain;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        fountain.buff((Drinker) actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + fountain.getWaterDescription();
    }
}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import game.grounds.Fountain;
import game.items.Water;

public class FillBottleAction extends Action {
    private Water water;
    private Fountain fountain;

    public FillBottleAction(Fountain fountain) {
        this.fountain = fountain;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Ground ground = map.locationOf(actor).getGround();


        return actor + " fills bottle with ";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}

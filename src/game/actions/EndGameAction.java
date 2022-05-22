package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class EndGameAction extends Action {
    private Actor target;

    public EndGameAction(Actor target) {
        this.target = target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return "Princess Peach is Saved!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return target + " ends the game";
    }
}

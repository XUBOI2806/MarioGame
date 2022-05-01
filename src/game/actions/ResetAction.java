package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;
import game.reset.ResetManager;

public class ResetAction extends Action {

    public ResetAction() {
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run();
        actor.removeCapability(Status.RESET);
        return "Game has been reset";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Reset Game";
    }

    @Override
    public String hotkey() {
        return "r";
    }
}


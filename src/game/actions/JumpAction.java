package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class JumpAction extends Action {

    public JumpAction() {

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    @Override
    public String hotkey() {
        return super.hotkey();
    }

    @Override
    public Action getNextAction() {
        return super.getNextAction();
    }
}

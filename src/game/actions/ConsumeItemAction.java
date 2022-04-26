package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.ConsumeAble;

public class ConsumeItemAction extends Action {
    private ConsumeAble consumeAble;

    public ConsumeItemAction(ConsumeAble consumeAble) {
        this.consumeAble = consumeAble;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        return consumeAble.consumedBy(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " eats the " + consumeAble;
    }
}

package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.ConsumeItemAction;

public interface ConsumeAble {

    int increaseHP();

    ConsumeItemAction consumeAction(Actor actor);
}

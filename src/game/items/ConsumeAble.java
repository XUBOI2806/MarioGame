package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;

public interface ConsumeAble {

    Action consumeAction(Actor actor);
}

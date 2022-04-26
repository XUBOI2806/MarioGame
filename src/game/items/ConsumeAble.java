package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.actions.ConsumeItemAction;

public interface ConsumeAble {

    String consumedBy(Actor actor);
}

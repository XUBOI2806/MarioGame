package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public interface ConsumeAble {

    /**
     * Actor obtains an item from the target
     *
     * @param actor     The actor consuming the consumable item
     * @return String   The sentence of the action processed
     */
    String consumedBy(Actor actor);

}

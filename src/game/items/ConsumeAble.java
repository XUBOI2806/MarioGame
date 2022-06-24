package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface ConsumeAble {

    /**
     * Actor obtains an item from the target
     *
     * @param actor     The actor consuming the consumable item
     * @param map       The game map
     * @return String   The sentence of the action processed
     */
    String consumedBy(Actor actor, GameMap map);

}

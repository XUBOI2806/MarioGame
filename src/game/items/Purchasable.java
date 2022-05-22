package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public interface Purchasable {

    /**
     * Adds item to the actor after purchasable item
     * @param actor The actor receiving the purchasable item
     */
    void add_item(Actor actor);
}

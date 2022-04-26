package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public interface Purchasable {

    /**
     * The price of the item
     *
     * @return the price, in coin currency
     */
    void add_item(Actor actor);
}

package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public interface ObtainAble {

    /**
     * Actor obtains an item from the target
     *
     * @param actor     The actor receiving the obtainable item
     * @param target    The target giving the obtainable item
     * @return String   The sentence of the action processed
     */
    String obtainedBy(Actor actor, Actor target);

}

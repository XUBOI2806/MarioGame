package game.actions.attack;

import edu.monash.fit2099.engine.actors.Actor;

public class FireAttackAction extends AttackAction {

    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param direction
     */
    public FireAttackAction(Actor target, String direction) {
        super(target, direction);
    }
}

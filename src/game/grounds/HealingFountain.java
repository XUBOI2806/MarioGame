package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;

public class HealingFountain extends Fountain {
    /**
     * Constructor.
     *
     */

    public HealingFountain() {
        super('H');
    }

    @Override
    public void getWater() {
        super.getWater();

    }

    @Override
    public void buff(Actor actor) {
        super.buff(actor);
        actor.heal(50);
    }
}

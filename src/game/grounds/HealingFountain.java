package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;

public class HealingFountain extends Fountains{
    /**
     * Constructor.
     *
     */

    public HealingFountain() {
        super('H');
    }

    @Override
    public String getWater() {
        super.getWater();
        return "Healing Water";
    }

    @Override
    public void buff(Actor actor) {
        super.buff(actor);
        actor.heal(50);
    }
}

package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;

public class PowerFountain extends Fountains{
    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('H');
    }

    @Override
    public String getWater() {
        super.getWater();
        return "Power Water";
    }

    @Override
    public void buff(Actor actor) {
        super.buff(actor);
        actor.getIntr
    }

}

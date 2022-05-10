package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.grounds.Fountains;

public class MagicalWater implements ConsumeAble{

    private Bottle bottle;

    public MagicalWater() {
    }

    public String fills(Actor actor) {
        bottle.addWater(actor, this);
        return actor + " fills ";
    }

    @Override
    public String consumedBy(Actor actor) {
        return actor + " drinks ";
    }

    public String capability(Fountains fountain) {
        fountain.
    }
}

package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.grounds.Fountain;

public class Water{

    private Fountain fountain;

    public Water() {
    }

    public String addBuff(Actor actor, Fountain fountain) {
        fountain.buff(actor);
        return null;
    }
}



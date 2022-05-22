package game.items;

import game.actors.Drinker;
import game.grounds.fountains.Fountain;

/**
 * Class representing the Water from the fountain.
 */
public class Water{

    private Fountain fountain;

    /**
     * Constructor.
     *
     * @param fountain        The fountain that the water came from
     */
    public Water(Fountain fountain) {
        this.fountain = fountain;
    }

    /**
     * Buffs the actor
     * @param actor   A drinker that can be buffed
     */
    public void useBuff(Drinker actor){
        fountain.buff(actor);
    }

    /**
     * Name of the water depending on which fountain it came from
     * @return String   A String of the water's name
     */
    public String string(){
        return fountain.getWaterDescription();
    }

}



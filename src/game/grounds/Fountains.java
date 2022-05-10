package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

public abstract class Fountains extends Ground {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Fountains(char displayChar) {
        super(displayChar);
    }

    public String getWater(){
        return null;
    }

    public void buff(Actor actor) {
    }
}

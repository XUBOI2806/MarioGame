package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.actors.Status;

/**
 * Peach key to end the game!
 */
public class PeachKey extends Item {

    /**
     * Constructor
     */
    public PeachKey(){
        super("Princess Peach Key",'k',true);
        this.addCapability(Status.HAS_PEACH_KEY);
    }



}

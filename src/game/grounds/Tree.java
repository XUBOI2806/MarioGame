package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.reset.ResetManager;
import game.reset.Resettable;
import java.util.Random;

public class Tree extends HighGround implements Resettable {
    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     */
    public Tree() {
        super('+');
        registerInstance();
    }

    /**
     * Inform the ground of the passage of time.
     * This method is called once per turn.
     * @param location The location of the tree.
     */
    @Override
    public void tick(Location location) {
        if (this.hasCapability(Status.RESET)) {
            int i = rand.nextInt(2);
            if (i == 0) {
                location.setGround(new Dirt());
            }
            ResetManager.getInstance().cleanUp(this);
        }
    }

    /**
     * Allows any classes that use this interface to reset abilities, attributes, and/or items.
     */
    @Override
    public void resetInstance() {
        this.addCapability(Status.RESET);
    }


}




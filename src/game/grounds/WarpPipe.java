package game.grounds;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.PiranhaPlant;
import game.actors.Status;

import java.util.Random;

public class WarpPipe extends Ground {
    private int counter; //keep track of time

    protected Location location; //warp pipe's location

    Random rand = new Random();

    /**
     * Constructor
     */
    public WarpPipe() {
        super('C');
        counter = 0;
        this.addCapability(Status.WARPPIPE);
    }


    /**
     * Describe the action in a format suitable for displaying in the menu.
     * @param location randomly spawning warp pipe and after 1 turn has past piranha plants are spawned on the warp pipe
     */
    @Override
    public void tick(Location location) {
        counter += 1;
        if (counter == 0) {
            int j = rand.nextInt(8);
            if (j == 1) {
                location.setGround(new WarpPipe());
            }
        }

        if(counter > 1){ //after 1st turn
            if(location.getGround().hasCapability(Status.WARPPIPE)){ //warpipe will automatically have a warppipe
                location.addActor(new PiranhaPlant());
            }
        }
    }

}


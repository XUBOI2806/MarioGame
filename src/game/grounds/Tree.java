package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.reset.Resettable;

import java.util.Random;

public class Tree extends Ground implements Resettable {
    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+');
    }

    @Override
    public void tick(Location location){
        if (this.hasCapability(Status.RESET)){
            int i = rand.nextInt(2);
            if (i == 1){
                location.setGround(new Dirt());
            }
        }
    }


    @Override
    public void resetInstance() {
        this.addCapability(Status.RESET);
    }
}

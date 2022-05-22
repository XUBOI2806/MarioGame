package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;

import java.util.Random;

public class WarpPipe extends Ground {
    private int counter;

    protected Location location; //warp pipe's location

    Random rand = new Random();

    public WarpPipe() {
        super('C');
        counter = 0;
        this.addCapability(Status.WARPPIPE);
    }

    @Override
    public void tick(Location location) {
        counter += 1;
        if (counter == 0) {
            int j = rand.nextInt(8);
            if (j == 1) {
                location.setGround(new WarpPipe());
            }
        }
    }

}


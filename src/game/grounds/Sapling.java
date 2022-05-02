package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.items.Coin;

public class Sapling extends Tree {
    private int counter;

    public Sapling() {
        super.setDisplayChar('t');
    }

    @Override
    public void tick(Location location) {
        counter += 1;
        if (counter % 10 == 0 && !location.containsAnActor()) ; //Every 10 rounds and no actor standing on location
        {
            location.setGround(new Mature()); //Mature is spawned
        }

        if (counter % 1 == 0 && !location.containsAnActor()) ;
        {
            if (Math.random() <= 0.1) ; //10% chance
            {
                location.addItem(new Coin(20)); // of Coin is spawned with the value of $20
            }
        }
    }
}
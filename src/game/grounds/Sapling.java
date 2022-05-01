package game.grounds;

import edu.monash.fit2099.engine.positions.Location;

public class Sapling extends Tree.Tree {
    private int counter;

    public Sapling() {
        super("t");
    }

    @Override
    public void tick(Location location) {
        counter += 1;
        if (counter % 10 == 0 && !location.containsAnActor()) ;
        {

            location.addTree(new Mature());
        }

        if (counter % 1 == 0 && !location.containsAnActor()) ;
        {
            if (Math.random() <= 0.1) ;
            {
                location.addItem(new Coin()); // note value is $20 dont forget to set that
            }
        }
    }
}
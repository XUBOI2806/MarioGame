package game.grounds;

import game.actors.Goomba;

public class Sprout extends Tree {
    private int counter;

    public Sprout() {
        super("+");
        {
            @Override
            public void tick (Location location)
            {
                counter += 1;
                if (counter % 10 == 0 && !location.containsAnActor()) ;
                {
                    location.addTree(new Sapling());
                }

                if (counter % 1 == 0 && !location.containsAnActor()) ;
                {
                    if (Math.random() <= 0.1) ;
                    {
                        location.addActor(new Goomba());
                    }
                }
            }
        }
    }
}

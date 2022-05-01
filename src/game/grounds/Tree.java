package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.reset.ResetManager;
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
            ResetManager.getInstance().cleanUp(this);
        }
    }


    @Override
    public void resetInstance() {
        this.addCapability(Status.RESET);}

    public class Tree extends Ground
    {
        private int counter;

        public Tree()
        {
            super('T');
        }

        @Override
        public void tick(Location location)
        {
            counter += 1;
        }
    }

    public class Sprout extends Tree
    {
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

            public class Sapling extends Tree {
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

            public class Mature extends Tree {
                private int counter;

                public Mature() {
                    super("T");
                    {

                        @Override
                        public void tick (Location location)
                        {
                            counter += 1;
                            if (counter % 5 == 0 && !location.containsAnActor()) ;
                            {
                                //surrounding location given if dirt(fertile)
                                if (############################)
                                {
                                    location.addTree(new Sprout());
                                }
                            }

                            if (counter % 1 == 0 && !location.containsAnActor()) ;
                            {
                                if (Math.random() <= 0.15) ;
                                {
                                    location.addActor(new Koopa());
                                }
                                if (Math.random() <= 0.20) ;
                                {
                                    map.removeTree(this); // not sure if right command to remove tree ehhh
                                    location.addGround(new Dirt()); // idk addGround is valid cos of class func
                                }
                            }
                        }
                    }
                }
            }
        }
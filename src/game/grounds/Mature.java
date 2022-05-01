package game.grounds;

public class Mature extends Tree.Tree {
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

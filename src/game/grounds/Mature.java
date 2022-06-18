package game.grounds;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.koopa.GroundKoopa;
import game.actors.koopa.Koopa;



public class Mature extends Tree {
    /**
     * Counter to keep track of each turn
     */
    private int counter;

    /**
     * Constructor
     */
    public Mature() {
        super.setDisplayChar('T'); // Represent Mature as T
        counter = 0; // Counter is set to 0
        this.addCapability(State.MATURE);
    }

    /**
     * @param location, location of the Mature
     * Method is used to ensure that the conditions are right for the mature to either spawn Koopa,
     * grow sprout in surrounding area or wither back into dirt
     */
    @Override
    public void tick(Location location) { // Keep tracks of each turn
        counter += 1; //Keep track of each iteration we increase by 1

        if(counter%5 == 0 && !location.containsAnActor()){ //Every 5 turns and no actor
            for(int i = 0; i < location.getExits().toArray().length;i++){ //Iterates over possible exits
                if(location.getExits().get(i).getDestination().getGround().hasCapability(State.FERTILE)){ //checks if location is fertile
                    location.getExits().get(i).getDestination().setGround(new Sprout()); //Grow new sprout if all conditions
                                                                                        //are met
                    break; // we only to spawn one sprout at a time every 5 times
                }

            }

        }

        if (!location.containsAnActor()) { //Every turn as long as there isn't an actor on the location

            if (Math.random() <= 0.15) { // 15% chance of spawning a Koopa
                location.addActor(new GroundKoopa());
            }
            if (Math.random() <= 0.20) { // 20% chance of
                location.setGround(new Dirt()); // Mature withers to Dirt
            }
        }
    }
}

package game.grounds;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Coin;

public class Sapling extends Tree {
    /**
     * Counter to keep track of each turn
     */
    private int counter;

    public final int fallDamage = 20;

    public final int successRate = 80;


    /**
     * Constructor
     */
    public Sapling() {
        super.setDisplayChar('t');
        this.addCapability(State.SAPLING);
        counter = 0;
    }

    /**
     * @param location, location of the Sapling
     * Method is used to ensure that the conditions are right for the Sapling to either spawn coin or grow into Mature
     */
    @Override
    public void tick(Location location) {
        counter += 1;
        if(counter % 10 == 0 && !location.containsAnActor()) {//Every 10 rounds and no actor standing on location{
            location.setGround(new Mature()); //Mature is spawned
        }

        if (!location.containsAnActor()){ //No actor standing on the coin
            if (Math.random() <= 0.1) { //10% chance
                location.addItem(new Coin(20)); // of Coin is spawned with the value of $20
            }
        }
    }
}
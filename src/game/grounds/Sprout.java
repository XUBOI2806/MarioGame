package game.grounds;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Goomba;
import game.items.FireFlower;

public class Sprout extends Tree {
    /**
     * Counter to keep track of each turn
     */
    private int counter;


    public Sprout() {
        counter = 0;
        super.setDisplayChar('+'); //Represent sprout with a +
        this.hasCapability(State.SPROUT);
    }

    /**
     * @param location, location of the Sprout
     * Method is used to ensure that the conditions are right for the Sprout to either spawn Goomba or grow into Sapling
     */
    @Override
    public void tick(Location location){ //Keep tracks of each turn
        counter += 1; //Each turn the counter goes up by one
        if (counter % 10 == 0 && !location.containsAnActor()){ //Every 10 turns and actor isn't on location
            location.setGround(new Sapling()); //Sapling is spawned
            if(Math.random()<= 0.5){ // 50% chance of
                location.addItem(new FireFlower()); // Fireflower is added to the location
            }
        }

        if (!location.containsAnActor()){ //Every turn
            if(Math.random() <= 0.1) //10% chance of as long no Actor is standing on location
            {
                location.addActor(new Goomba()); //Goomba is spawned
            }
        }
    }
}

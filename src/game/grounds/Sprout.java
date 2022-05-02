package game.grounds;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Goomba;

public class Sprout extends Tree {
    private int counter;

    public Sprout() {
        super('+'); //Represent sprout with a +
    }
    @Override
    public void tick(Location location){ //Keep tracks of each turn
        counter += 1; //Each turn the counter goes up by one
        if (counter % 10 == 0 && !location.containsAnActor()){ //Every 10 turns and actor isn't on location
            location.setGround(new Sapling()); //Sapling is spawned
        }

        if (!location.containsAnActor()){ //Every turn
            if(Math.random() <= 0.1) //10% chance of as long no Actor is standing on location
            {
                location.addActor(new Goomba()); //Goomba is spawned
            }
        }
    }
}

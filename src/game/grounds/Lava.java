package game.grounds;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;

import java.util.Random;

public class Lava extends Ground {
    private int counter;

    protected Actor actor;

    Random rand = new Random();

    public Lava() {
        super('L');
        counter = 0;
    }


    @Override
    public void tick(Location location) {
        counter += 1;

        actor = location.getActor(); //actor on the location on the lava

        //spawns fire ground randomly on the game map at the beginning of the turn
        if(counter == 0 && !location.containsAnActor())
        {
            int j = rand.nextInt(7);
            if(j == 1){
                location.setGround(new Lava());
            }
        }

        //checks if lava contains a player
        if (actor.hasCapability(Status.FLOOR)&& location.canActorEnter(actor)) { //only players cant enter onto lava
            actor.hurt(15);
        }
    }
}



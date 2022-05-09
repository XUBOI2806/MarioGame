package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.Utils;

public class FireGround extends Ground {
    private int damage;
    // Constructor
    public FireGround(){
        super('L');
        this.damage = Utils.FIRE_DAMAGE;
    }


    @Override
    public boolean canActorEnter(Actor actor) {
        if(actor.hasCapability(Status.FLOOR)){
            return true;
        }
        return false;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor()){
            actor.hurt(damage);
        }
        return super.allowableActions(actor, location, direction);
    }
}

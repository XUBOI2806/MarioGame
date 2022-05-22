package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.Coin;
import game.items.Utils;

public abstract class HighGround extends Ground {

    public HighGround(char displayChar){
        super(displayChar);
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.INVINCIBLE)) {
            return true;
        }
        return false;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor() && location.getActor().hasCapability(Status.INVINCIBLE)){
            location.setGround(new Dirt());
            location.addItem(new Coin(Utils.DESTROYED_GROUND_VALUE));
        }
        return super.allowableActions(actor, location, direction);
    }
}

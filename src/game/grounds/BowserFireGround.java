package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Utils;

public class BowserFireGround extends FireGround{
    private int damage;
    public BowserFireGround(){
        super();
        this.damage = Utils.BOWSER_FIRE_DAMAGE;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return true;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        return super.allowableActions(actor, location, direction);
    }
}

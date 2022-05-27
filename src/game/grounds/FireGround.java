package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Utils;

public class FireGround extends Ground {
    private int damage;
    private Ground oldGround;
    private int age;

    public FireGround(Ground oldGround){
        super('v');
        this.oldGround = oldGround;
        this.damage = Utils.FIRE_DAMAGE;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return oldGround.canActorEnter(actor);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor()){
            actor.hurt(damage);
        }
        return super.allowableActions(actor, location, direction);
    }

    @Override
    public void tick(Location location) {
        this.age++;
        if(this.age == 3){
            location.setGround(this.oldGround);
        }
    }

    public void previousGround(Ground oldGround){
        this.oldGround = oldGround;
    }
}

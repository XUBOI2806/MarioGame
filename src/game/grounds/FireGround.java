package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Utils;

/**
 * A class that represents fire on the ground. Extends the ground class.
 */
public class FireGround extends Ground {
    private int damage;
    private Ground oldGround;
    private int age;

    /**
     * Constructor
     * @param oldGround the previous type of ground
     */
    public FireGround(Ground oldGround){
        super('v');
        this.oldGround = oldGround;
        this.damage = Utils.FIRE_DAMAGE;
    }

    /**
     * Can actor enter based on the previous ground.
     * @param actor the Actor to check
     * @return boolean of whether actor can enter
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return oldGround.canActorEnter(actor);
    }

    /**
     * Allowable actions of the ground. Also damages any actor on top of this ground.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return ActionList of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor()){
            actor.hurt(damage);
        }
        return super.allowableActions(actor, location, direction);
    }

    /**
     * Ticks the age of the ground. Once 3 turns have passed. Return to the old ground.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.age++;
        if(this.age == 3){
            location.setGround(this.oldGround);
        }
    }
}

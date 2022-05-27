package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actors.Status;

import java.util.ArrayList;
import java.util.List;

public class FireFlower extends Item implements ConsumeAble {

    private ConsumeAction consume;
    private int age = 0;
    /***
     * Constructor.
     */
    public FireFlower() {
        super("Fire Flower", 'f', Boolean.parseBoolean("True"));
        this.consume = new ConsumeAction(this);
        this.addAction(consume);
    }

    @Override
    public String consumedBy(Actor actor, GameMap map) {
        this.addCapability(Status.FIRE);
        this.removeAction(consume);
        this.togglePortability();
        if(map.locationOf(actor).getItems().contains(this)) {
            map.locationOf(actor).removeItem(this);
            actor.addItemToInventory(this);
        }
        return actor + " ate the fire flower";
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        System.out.println(age);
        if(age == Utils.FIRE_FLOWER_EXPIRY){
            actor.removeItemFromInventory(this);
        }

        if(this.hasCapability(Status.FIRE)){
            age++;
        }
    }
}

package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeItemAction;
import game.actors.Status;
import edu.monash.fit2099.engine.displays.Display;
import game.grounds.Dirt;

import java.util.ArrayList;
import java.util.List;

public class PowerStar extends Item implements Purchasable, ConsumeAble {
    private int age = 0;
    private int turns_left;
    private ConsumeItemAction consume;
    private boolean consumed;

    public PowerStar() {
        super("Power Star", '*', Boolean.parseBoolean("True"));
        this.consume = new ConsumeItemAction(this);
        this.addAction(consume);
        this.turns_left = 11;
    }

    public void add_item(Actor actor){
        actor.addItemToInventory(this);
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.heal(1000);
        actor.addCapability(Status.INVINCIBLE);
        this.removeAction(consume);
        this.consumed = true;
        this.togglePortability();
        return actor + " ate the power star";
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        age++;
        if(actor.hasCapability(Status.INVINCIBLE)){
            if(currentLocation.getGround().getDisplayChar() == '+' || currentLocation.getGround().getDisplayChar() == '#'){
                currentLocation.setGround(new Dirt());
                currentLocation.addItem(new Coin(5));
            }
            this.turns_left--;
        }
        if (age == 10 & !actor.hasCapability(Status.INVINCIBLE)) {
            actor.removeItemFromInventory(this);
        }

        if(turns_left == 0){
            actor.removeItemFromInventory(this);
            actor.removeCapability(Status.INVINCIBLE);
        }

    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        age++;
        if (age == 10) {
            currentLocation.removeItem(this);
        }
    }

    @Override
    public String toString() {
        if(this.consumed == false){
            int turnsLeft = 10 - this.age;
            return super.toString() + " (" + turnsLeft + " turns left)";
        }
        return super.toString();
    }
}


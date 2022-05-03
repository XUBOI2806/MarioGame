package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actors.Status;
import game.grounds.Dirt;

public class PowerStar extends Item implements Purchasable, ConsumeAble {
    private int age = 0;
    private int turns_left;
    private ConsumeAction consume;
    private boolean displayExpiry;

    /**
     * Constructor
     */
    public PowerStar() {
        super("Power Star", '*', Boolean.parseBoolean("True"));
        this.consume = new ConsumeAction(this);
        this.addAction(consume);
        this.turns_left = Utils.INVICIBLE_TURNS_LEFT;
    }

    /**
     * Adds the power star to an actor's inventory
     * @param actor the actor to add to
     */
    public void add_item(Actor actor){
        actor.addItemToInventory(this);
    }

    /**
     * Execution of consuming the power star which heals the player and adds INVINCIBLE status.
     * @param actor
     * @return returns the description of consuming power star
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.heal(Utils.POWER_STAR_HP_INCREASE);
        actor.addCapability(Status.INVINCIBLE);
        this.removeAction(consume);
        this.togglePortability();
        return actor + " ate the power star";
    }

    /**
     * Checks the amount of turns of actor carrying item for the power star in order to expire or for INVINCIBLE status to wear off
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        this.displayExpiry = false;
        super.tick(currentLocation, actor);
        age++;
        if(actor.hasCapability(Status.INVINCIBLE)){
            if(currentLocation.getGround().getDisplayChar() == '+' || currentLocation.getGround().getDisplayChar() == '#'){
                currentLocation.setGround(new Dirt());
                currentLocation.addItem(new Coin(Utils.DESTROYED_GROUND_VALUE));
            }
            this.turns_left--;
        }
        if (age == Utils.POWER_STAR_EXPIRY_AGE & !actor.hasCapability(Status.INVINCIBLE)) {
            actor.removeItemFromInventory(this);
        }

        if(turns_left == 0){
            actor.removeItemFromInventory(this);
            actor.removeCapability(Status.INVINCIBLE);
        }

    }

    /**
     * Checks the amount of turns on the ground
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        this.displayExpiry = true;
        super.tick(currentLocation);
        age++;
        if (age == Utils.POWER_STAR_EXPIRY_AGE) {
            currentLocation.removeItem(this);
        }
    }

    /**
     * String to print out for the power star
     * @return A string of the power star
     */
    @Override
    public String toString() {
        if(this.displayExpiry == true){
            int turnsLeft = Utils.POWER_STAR_EXPIRY_AGE - this.age;
            return super.toString() + " (" + turnsLeft + " turns left)";
        }
        return super.toString();
    }
}


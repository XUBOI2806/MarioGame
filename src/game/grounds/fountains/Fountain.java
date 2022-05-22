package game.grounds.fountains;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.BottleManager.BottleManager;
import game.actions.FillBottleAction;
import game.actors.Drinker;
import game.actors.Status;
import game.items.Utils;

public abstract class Fountain extends Ground {

    private int replenish_age;

    private int capacity;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Fountain(char displayChar) {
        super(displayChar);
        this.addCapability(Status.FOUNTAIN);
        this.capacity = Utils.FOUNTAIN_FULL_AMOUNT;
        this.replenish_age = Utils.FOUNTAIN_REFILL_AGE;
    }

    /**
     * Returns an empty Action list.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor() && actor.hasCapability(Status.HAS_BOTTLE)){
            return new ActionList(new FillBottleAction(this));
        }
        return super.allowableActions(actor, location, direction);
    }

    /**
     * Adds water to the actor's bottle if there is any water within the fountain
     * @param actor The actor to receive the water
     * @return a string of what action has been processed
     */
    public String getWater(Actor actor){
        if (capacity > 0){
            BottleManager.getInstance().addWater(actor, this);
            this.capacity -= 1;
            return actor + " refills bottle with " + this.getWaterDescription();
        }
        return getFountainDescription() + " is being replenished";
    }

    /**
     * Buffs the actor depending on the water
     * @param actor The actor to be buffed
     */
    public void buff(Drinker actor) {
    }

    /**
     * Water Name
     * @return A string of the water name depending on the fountain that it came from
     */
    public abstract String getWaterDescription();

    /**
     * Fountain Name
     * @return A string of the fountain name
     */
    public abstract String getFountainDescription();

    /**
     * Ground can also experience the joy of time.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (this.capacity == 0){
            if (this.replenish_age == 0){
                this.capacity = Utils.FOUNTAIN_FULL_AMOUNT;
                this.replenish_age = Utils.FOUNTAIN_REFILL_AGE;
            }
            else{
                this.replenish_age -= 1;
            }
        }
    }

    /**
     * Fountain Capacity
     * @return A string of the amount of water left in the fountain
     */
    public String getCapacity(){
        return "(" + this.capacity + "/" + Utils.FOUNTAIN_FULL_AMOUNT + ")";
    }
}

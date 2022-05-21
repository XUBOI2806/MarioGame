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

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor() && actor.hasCapability(Status.HAS_BOTTLE)){
            return new ActionList(new FillBottleAction(this));
        }
        return super.allowableActions(actor, location, direction);
    }

    public String getWater(Actor actor){
        if (capacity > 0){
            BottleManager.getInstance().addWater(actor, this);
            this.capacity -= 1;
            return actor + " refills bottle with " + this.getWaterDescription();
        }
        return getFountainDescription() + " is being replenished";
    }

    public void buff(Drinker actor) {
    }

    public abstract String getWaterDescription();

    public abstract String getFountainDescription();

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

    public String getCapacity(){
        return "(" + this.capacity + "/" + Utils.FOUNTAIN_FULL_AMOUNT + ")";
    }
}

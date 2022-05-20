package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.FillBottleAction;
import game.actors.Drinker;
import game.actors.Status;

public abstract class Fountain extends Ground {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Fountain(char displayChar) {
        super(displayChar);
        this.addCapability(Status.FOUNTAIN);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if(location.containsAnActor()){
            return new ActionList(new FillBottleAction(this));

        }
        return super.allowableActions(actor, location, direction);
    }

    public void getWater(Actor actor){
    }

    public void buff(Drinker actor) {
    }

    public abstract String getWaterDescription();
}

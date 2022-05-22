package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.BottleManager;
import game.actors.Drinker;
import game.items.Utils;
import game.items.Water;

public class HealingFountain extends Fountain {

    private Water water;

    /**
     * Constructor.
     *
     */

    public HealingFountain() {
        super('H');
        this.water = new Water(this);
    }

    @Override
    public void buff(Drinker actor) {
        super.buff(actor);
        actor.fountainHeal(Utils.HEALTH_FOUNTAIN_WATER_HP);
    }

    @Override
    public String getWaterDescription() {
        return "Healing Water";
    }

    @Override
    public String getFountainDescription(){
        return "Healing Fountain";
    }
}

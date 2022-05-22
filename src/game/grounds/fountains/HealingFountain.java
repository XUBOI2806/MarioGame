package game.grounds.fountains;

import game.actors.Drinker;
import game.items.Utils;

public class HealingFountain extends Fountain {

    private String waterName;
    private String name;

    /**
     * Constructor.
     *
     */
    public HealingFountain() {
        super('H');
        this.name = "Healing Fountain";
        this.waterName = "Healing Water";
    }

    /**
     * Buffs the actor by healing the actor
     * @param actor The actor to be healed
     */
    @Override
    public void buff(Drinker actor) {
        super.buff(actor);
        actor.fountainHeal(Utils.HEALTH_FOUNTAIN_WATER_HP);
    }

    /**
     * Water Name
     * @return A string of the water name
     */
    @Override
    public String getWaterDescription() {
        return this.waterName;
    }

    /**
     * Fountain Name
     * @return A string of the fountain name
     */
    @Override
    public String getFountainDescription(){
        return this.name;
    }
}

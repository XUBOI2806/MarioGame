package game.grounds.fountains;

import game.actors.Drinker;
import game.items.Utils;

public class PowerFountain extends Fountain {

    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('A');
    }

    /**
     * Buffs the actor depending on the water
     * @param actor The actor to be buffed
     */
    @Override
    public void buff(Drinker actor) {
        super.buff(actor);
        actor.fountainIncreaseAttack(Utils.POWER_FOUNTAIN_ATTACK_INCREASE);
    }

    /**
     * Water Name
     * @return A string of the water name
     */
    @Override
    public String getWaterDescription() {
        return "Power Water";
    }

    /**
     * Fountain Name
     * @return A string of the fountain name
     */
    @Override
    public String getFountainDescription(){
        return "Power Fountain";
    }
}

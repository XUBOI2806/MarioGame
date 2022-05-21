package game.grounds.fountains;

import game.actors.Drinker;
import game.items.Bottle;

public class PowerFountain extends Fountain {

    Bottle bottle;
    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('A');
    }

    @Override
    public void buff(Drinker actor) {
        super.buff(actor);
        actor.fountainIncreaseAttack();
    }

    @Override
    public String getWaterDescription() {
        return "Power Water";
    }

    @Override
    public String getFountainDescription(){
        return "Power Fountain";
    }
}

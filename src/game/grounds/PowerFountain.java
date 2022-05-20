package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.BottleManager;
import game.actors.Drinker;
import game.actors.Player;
import game.items.Bottle;
import game.items.Utils;

public class PowerFountain extends Fountain {

    Bottle bottle;
    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('H');
    }

    @Override
    public void buff(Drinker actor) {
        super.buff(actor);
        actor.fountainIncreaseAttack();
    }

    @Override
    public void getWater(Actor actor) {
        BottleManager.getInstance().addWater(actor, this);
    }

    @Override
    public String getWaterDescription() {
        return "Power Water";
    }
}

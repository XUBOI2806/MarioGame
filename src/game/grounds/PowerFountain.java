package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Player;
import game.items.Bottle;

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
    public void getWater(Player player) {
         = player.getBottle()
        super.getWater();


    }

    @Override
    public void buff(Actor actor) {
        super.buff(actor);
    }

}

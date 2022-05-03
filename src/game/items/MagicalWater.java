package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public abstract class MagicalWater implements ConsumeAble{
    @Override
    public String consumedBy(Actor actor) {
        actor.heal(Utils.HEALTH_FOUNTAIN_WATER_HP);
        return actor + " drinks ";
    }
}

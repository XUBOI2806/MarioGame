package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.DrinkWaterFromFountainAction;
import game.grounds.fountains.Fountain;

/**
 * A behaviour that decides an AttackAction for a hostile player when within the range of the exits
 */
public class DrinkBehaviour implements Behaviour {

    private Fountain fountain;

    /**
     * Constructor for AttackBehaviour
     */
    public DrinkBehaviour(Fountain fountain) {
        this.fountain = fountain;
    }

    /**
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return AttackAction if it finds a target, null if not
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return new DrinkWaterFromFountainAction(fountain);
    }
}

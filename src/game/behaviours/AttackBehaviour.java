package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.actors.Status;

/**
 * A behaviour that decides an AttackAction for a hostile player when within the range of the exits
 */
public class AttackBehaviour implements Behaviour {

    private Actor target;

    // TODO: develop and use it to attack the player automatically.

    /**
     * Constructor for AttackBehaviour
     * @param target the actor to attack
     */
    public AttackBehaviour(Actor target) {
        this.target = target;
    }

    /**
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return AttackAction if it finds a target, null if not
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location targetLocation = map.locationOf(this.target);
        for(Exit exit: map.locationOf(actor).getExits()){
            if(exit.getDestination().getActor() == this.target && targetLocation.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)){
                return new AttackAction(this.target,exit.getName());
            }
        }
        return null;
    }
}

package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.actors.Status;

public class AttackBehaviour implements Behaviour {

    // TODO: develop and use it to attack the player automatically.
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for(Exit exit: map.locationOf(actor).getExits()){
            Location targetLocation = exit.getDestination();
            if(targetLocation.containsAnActor() && targetLocation.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)){
                Actor target = targetLocation.getActor();
                return new AttackAction(target,exit.getName());
            }
        }
        return null;
    }
}

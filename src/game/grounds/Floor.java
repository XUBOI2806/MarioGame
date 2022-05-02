package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actors.Status;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground {
	/**
	 * Constructor
	 */
	public Floor() {
		super('_');
	}


	/**
	 * Checks if an actor can enter, only actors that have status FLOOR should be able to get in
	 * @param actor the Actor to check
	 * @return returns a boolean
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if(actor.hasCapability(Status.FLOOR)){
			return true;
		}
		return false;
	}
}

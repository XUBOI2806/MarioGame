package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actors.Status;

public class Wall extends Ground {

	public Wall() {
		super('#');
	}

	/**
	 * Checks if an actor can enter, only actors that have INVINCIBLE status should be able to enter
	 * @param actor the Actor to check
	 * @return true if actor is invincible, else false
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasCapability(Status.INVINCIBLE)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

}

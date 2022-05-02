package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;

public class Wall extends Ground {

	public Wall() {
		super('#');
	}

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

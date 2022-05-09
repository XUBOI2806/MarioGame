package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actors.Status;

public class Wall extends HighGround {

	public Wall() {
		super('#');
	}

	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

}

package game.grounds;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeItemAction;
import game.actions.DestroyGroundAction;
import game.actors.Status;

import java.util.ArrayList;

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

	@Override
	public ActionList allowableActions(Actor actor, Location location, String direction) {
		 ActionList actions = new ActionList();
		 actions.add(new DestroyGroundAction(location,direction));
		 return actions;
	}
}

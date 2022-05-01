package game.actions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actors.Status;
import game.reset.ResetManager;
import game.reset.Resettable;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;

	/**
	 * The direction of incoming attack.
	 */
	protected String direction;

	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target, String direction) {
		this.target = target;
		this.direction = direction;
	}

	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();

		if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
			return actor + " misses " + target + ".";
		}

		int damage = weapon.damage();

		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";

		// If the defender has an invincible status no damage
		if(target.hasCapability(Status.INVINCIBLE)){
			damage = 0;
			result = target + " is invincible and cannot be damaged";
		}

		// If the attacker has an invincible status 1 hit KO
		if(actor.hasCapability(Status.INVINCIBLE)){
			damage = 10000; // if actor has consumed super star then actor can one hit kill
			result = actor + " one hit kills " + target;
		}

		target.hurt(damage);
		if (!target.isConscious()) {
			ActionList dropActions = new ActionList();
			// drop all items
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction(actor));
			for (Action drop : dropActions)
				drop.execute(target, map);
			// remove actor or activate dormant state
			if(target.hasCapability(Status.DORMANT_ABLE)){
				target.removeCapability(Status.DORMANT_ABLE);
				target.addCapability(Status.DORMANT);
				result += System.lineSeparator() + target + " is now dormant.";
			}
			else{
				map.removeActor(target);
				ResetManager.getInstance().cleanUp((Resettable) target);
				result += System.lineSeparator() + target + " is killed.";
			}

		}

		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target + " at " + direction;
	}
}

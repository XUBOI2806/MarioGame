package game.actors;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.attack.AttackAction;
import game.actions.DestructAction;
import game.actions.SpeakAction;
import game.actors.monologue.Monologue;
import game.actors.monologue.Speakable;
import game.behaviours.*;
import game.grounds.fountains.Fountain;
import game.items.Utils;
import game.reset.ResetManager;
import game.reset.Resettable;

import java.util.*;

/**
 * A little fungus guy.
 */
public class Goomba extends Enemy implements Resettable, Speakable, Drinker {
	private final Random random = new Random();

	private int damage;
	/**
	 * Constructor.
	 */
	public Goomba() {
		super("Goomba", 'g', 20);
		this.behaviours.put(10, new WanderBehaviour());
		registerInstance();
		this.damage = Utils.GOOMBA_BASE_DAMAGE;
	}

	/**
	 * Decides the actions that another actor can perform. Also decides to put in specific behaviours when the other
	 * actor is hostile.
	 * @param otherActor the Actor that might perform an action.
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return A collection of Actions.
	 * @see Status#HOSTILE_TO_ENEMY
	 */
	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actions = super.allowableActions(otherActor, direction, map);
		// it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
		if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
			if(!behaviours.containsKey(9)) {
				this.behaviours.put(9, new FollowBehaviour(otherActor));
			}
		}
		return actions;
	}

	/**
	 * Figure out what to do next.
	 * @see Actor#playTurn(ActionList, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

		if(map.locationOf(this).getGround().hasCapability(Status.FOUNTAIN)){
			this.behaviours.put(9, new DrinkBehaviour((Fountain) map.locationOf(this).getGround()));
		}
		else{
			this.behaviours.remove(9);
		}

		if (this.hasCapability(Status.RESET)) {
			this.behaviours.clear();
			map.removeActor(this);
			ResetManager.getInstance().cleanUp(this);
		}

		// 10% chance of removing the actor
		if(random.nextInt(9) < 1){
			return new DestructAction();
		}

		if (this.hasCapability(Status.TALK)){
			this.removeCapability(Status.TALK);
			String monologue = new SpeakAction(this).execute(this, map);
			display.println(monologue);
		}
		else{
			this.addCapability(Status.TALK);
		}

		return super.playTurn(actions, lastAction, map, display);
	}

	/**
	 * Creates and returns an intrinsic weapon.
	 *
	 * The Actor 'kicks' for damage that might be changed.
	 *
	 * @return an IntrinsicWeapon
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(this.damage,"kicks");
	}

	/**
	 * Allows any classes that use this interface to reset abilities, attributes, and/or items.
	 */
	@Override
	public void resetInstance() {
		this.addCapability(Status.RESET);
	}

	/**
	 * Returns a collection of the statements that the current Actor can say from the target's conditions.
	 *
	 * @param target the Actor's conditions that need to be checked
	 * @return A collection of sentences.
	 */
	@Override
	public List<Monologue> sentences(Actor target) {
		ArrayList<Monologue> sentenceList = new ArrayList<>();
		sentenceList.add(new Monologue(this, "Mugga mugga!"));
		sentenceList.add(new Monologue(this, "Ugha ugha... (Never gonna run around and desert you...)"));
		sentenceList.add(new Monologue(this, "Ooga-Chaka Ooga-Ooga!"));
		return sentenceList;
	}

	/**
	 * Applies a buff to anyone that drinks from the Power Fountain
	 *
	 */
	@Override
	public void fountainIncreaseAttack(int attack) {
		this.damage += attack;
	}

	/**
	 * Applies healing to anyone that drinks from the Healing Fountain
	 *
	 */
	@Override
	public void fountainHeal(int health) {
		this.heal(health);
	}
}

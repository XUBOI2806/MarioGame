package game.actors;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.SpeakAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.behaviours.Behaviour;
import game.reset.ResetManager;
import game.reset.Resettable;

import java.util.*;

/**
 * A little fungus guy.
 */
public class Goomba extends Actor implements Resettable, Speakable {
	private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
	private final Random random = new Random();
	/**
	 * Constructor.
	 */
	public Goomba() {
		super("Goomba", 'g', 20);
		this.behaviours.put(10, new WanderBehaviour());
		registerInstance();
	}

	/**
	 * Decides the actions that another actor can perform. Also decides to put in specific behaviours when the other
	 * actor is hostile.
	 * @param otherActor the Actor that might perform an action.
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return list of actions
	 * @see Status#HOSTILE_TO_ENEMY
	 */
	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actions = new ActionList();
		// it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
		if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
			actions.add(new AttackAction(this,direction));
			if(!behaviours.containsKey(8) && !behaviours.containsKey(9)) {
				this.behaviours.put(8, new AttackBehaviour(otherActor));
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
		if (this.hasCapability(Status.RESET)) {
			this.behaviours.clear();
			map.removeActor(this);
			ResetManager.getInstance().cleanUp(this);
		}

		this.remove(map);	// 10% chance of removing the actor

		for(Behaviour Behaviour : behaviours.values()) {
			Action action = Behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		if (this.hasCapability(Status.TALK)){
			this.removeCapability(Status.TALK);
			return new SpeakAction(this);
		}
		this.addCapability(Status.TALK);


		return new DoNothingAction();
	}

	/**
	 * Intrinsic weapon of damage 10 and the verb "kicks"
	 * @return
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10,"kicks");
	}

	private void remove(GameMap map){
		if(random.nextInt(9) < 1){
			this.behaviours.clear();
			map.removeActor(this);
		}
	}

	/**
	 * Allows any classes that use this interface to reset abilities, attributes, and/or items.
	 */
	@Override
	public void resetInstance() {
		this.addCapability(Status.RESET);
	}

	@Override
	public List<Monologue> sentences(Actor target) {
		ArrayList<Monologue> sentenceList = new ArrayList<>();
		sentenceList.add(new Monologue(this, "Mugga mugga!"));
		sentenceList.add(new Monologue(this, "Ugha ugha... (Never gonna run around and desert you...)"));
		sentenceList.add(new Monologue(this, "Ooga-Chaka Ooga-Ooga!"));
		return sentenceList;
	}

	@Override
	public Action nextAction() {
		return null;
	}

}

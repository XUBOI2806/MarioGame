package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.RemoveDormantActorAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.behaviours.Behaviour;
import game.items.SuperMushroom;
import game.reset.ResetManager;
import game.reset.Resettable;

import java.util.HashMap;
import java.util.Map;

/**
 * Koopa actor
 */
public class Koopa extends Actor implements Resettable {
    // Attributes
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour


    /**
     * Constructor for Koopa.
     */
    public Koopa() {
        super("Koopa", 'K', 100);
        this.behaviours.put(10, new WanderBehaviour());
        this.addItemToInventory(new SuperMushroom());
        this.addCapability(Status.DORMANT_ABLE);
        registerInstance();
    }


    // Action List

    /**
     * Decides the actions that another actor can perform. Also decides to put in specific behaviours when the other
     * actor is hostile. Also decides when another actor can remove the dormant koopa.
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && this.isConscious()) {
            actions.add(new AttackAction(this, direction));
            this.behaviours.put(8, new AttackBehaviour(otherActor));
            this.behaviours.put(9, new FollowBehaviour(otherActor));
        } else if (otherActor.hasCapability(Status.WRENCH)) {
            actions.add(new RemoveDormantActorAction(this, direction));
        }
        return actions;
    }

    /**
     * playTurn decides what action the Koopa should do next complicit with the behaviours.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return an action the koopa can perform, if it cannot do anything just DoNothingAction
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.RESET)) {
            this.behaviours.clear();
            map.removeActor(this);
            ResetManager.getInstance().cleanUp(this);
        }

        if (!this.hasCapability(Status.DORMANT)) {
            for (Behaviour Behaviour : behaviours.values()) {
                Action action = Behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }

        return new DoNothingAction();
    }

    /**
     * Gives the display character
     * @return 'K' if not dormant, 'D' if dormant
     */
    @Override
    public char getDisplayChar() {
        if (this.hasCapability(Status.DORMANT)) {
            super.setDisplayChar('D');
            return super.getDisplayChar();
        }
        return super.getDisplayChar();
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30, "punches");
    }

    /**
     * Allows any classes that use this interface to reset abilities, attributes, and/or items.
     */
    @Override
    public void resetInstance() {
        this.addCapability(Status.RESET);
    }

}
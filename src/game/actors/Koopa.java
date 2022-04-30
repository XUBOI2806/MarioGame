package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.RemoveActorAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.behaviours.Behaviour;
import game.items.SuperMushroom;
import game.reset.Resettable;

import java.util.HashMap;
import java.util.Map;


public class Koopa extends Actor implements Resettable {
    // Attributes
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour


    //Constructor
    public Koopa() {
        super("Koopa", 'K', 100);
        this.behaviours.put(8, new AttackBehaviour());
        this.behaviours.put(10, new WanderBehaviour());
        this.addItemToInventory(new SuperMushroom());
        this.addCapability(Status.DORMANT_ABLE);
        registerInstance();
    }

    // Methods

    // Action List
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && this.isConscious()) {
            actions.add(new AttackAction(this, direction));
            this.behaviours.put(9, new FollowBehaviour(otherActor));
        } else if (otherActor.hasCapability(Status.WRENCH)) {
            actions.add(new RemoveActorAction(this, direction));
        }
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.hasCapability(Status.DORMANT)) {
            for (Behaviour Behaviour : behaviours.values()) {
                Action action = Behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }
        if (this.hasCapability(Status.DEAD)) {
            this.resetMaxHp(0);
            }
        return new DoNothingAction();
    }

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

    @Override
    public void resetInstance() {
        this.addCapability(Status.DEAD);
    }

}
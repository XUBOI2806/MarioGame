package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.grounds.BowserFireGround;
import game.items.PeachKey;
import game.items.SuperMushroom;
import game.reset.ResetManager;
import game.reset.Resettable;

import java.util.HashMap;
import java.util.Map;

public class Bowser extends Actor implements Resettable {
    // Attributes
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    // Constructor
    public Bowser(){
        super("Bowser",'B',500);
        this.addCapability(Status.FIRE);
        this.addItemToInventory(new PeachKey());
        registerInstance();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this,direction));
            Ground previousGround = map.locationOf(otherActor).getGround();
            map.locationOf(otherActor).setGround(new BowserFireGround(previousGround));
            if(!behaviours.containsKey(8) && !behaviours.containsKey(9)) {
                this.behaviours.put(8, new AttackBehaviour(otherActor));
                this.behaviours.put(9, new FollowBehaviour(otherActor));
            }
        }
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.RESET)) {
            this.behaviours.clear();
            map.removeActor(this);
            ResetManager.getInstance().cleanUp(this);
        }

        for(Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }


        return new DoNothingAction();
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80,"punch");
    }



    // Reset is TODO
    @Override
    public void resetInstance(){
        this.addCapability(Status.RESET);
    }

}

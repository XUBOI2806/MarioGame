package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.HashMap;
import java.util.Map;


public class Koopa extends Actor{
    // Attributes
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour


    //Constructor
    public Koopa(){
        super("Koopa",'K',100);
        this.behaviours.put(10,new WanderBehaviour());
        this.addCapability(Status.DORMANT_ABLE);
    }

    // Methods

    // Action List
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && this.isConscious()) {
            actions.add(new AttackAction(this,direction));
        }
        else if(otherActor.hasCapability(Status.WRENCH))
        {
            actions.add(new RemoveAction(this,direction));
        }
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(!this.hasCapability(Status.DORMANT)){
            for(Behaviour Behaviour : behaviours.values()) {
                Action action = Behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }
        return new DoNothingAction();
    }


    public char getDisplayChar(){
        if(this.hasCapability(Status.DORMANT)){
            super.setDisplayChar('D');
            return super.getDisplayChar();
        }
        return super.getDisplayChar();
    }
}

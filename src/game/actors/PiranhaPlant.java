package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actions.SpeakAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PiranhaPlant extends Actor implements Speakable {

    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    /**
     * Constructor.
     *
     */
    public PiranhaPlant() {
        super("Piranha Plant",'Y',150);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this,direction));
            if(!behaviours.containsKey(8)) {
                this.behaviours.put(8, new AttackBehaviour(otherActor));
            }
        }
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (game.behaviours.Behaviour Behaviour : behaviours.values()) {
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

    @Override
    public List<Monologue> sentences(Actor target) {
        ArrayList<Monologue> sentenceList = new ArrayList<>();
        sentenceList.add(new Monologue(this, "Slsstssthshs~! (Never gonna say goodbye~)"));
        sentenceList.add(new Monologue(this, "Ohmnom nom nom nom."));
        return sentenceList;
    }

    @Override
    public Action nextAction() {
        return null;
    }

}


package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SpeakAction;

import java.util.ArrayList;
import java.util.List;

public class PrincessPeach extends Actor implements Speakable{

    public PrincessPeach(){
        super("Princess Peach",'P', 1);
        this.addCapability(Status.ODD);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.EVEN)){
            this.removeCapability(Status.EVEN);
            this.addCapability(Status.ODD);
            return new SpeakAction(this);
        }
        this.removeCapability(Status.ODD);
        this.addCapability(Status.EVEN);
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if(otherActor.hasCapability(Status.HAS_PEACH_KEY)){
            actions.add(new SpeakAction(this));
        }
        return actions;
    }

    @Override
    public List<Monologue> sentences(Actor target) {
        ArrayList<Monologue> sentenceList = new ArrayList<>();
        sentenceList.add(new Monologue(this, "Dear Mario, I'll be waiting for you..."));
        sentenceList.add(new Monologue(this, "Never gonna give you up!"));
        sentenceList.add(new Monologue(this, "Release me, or I will kick you!"));
        return sentenceList;
    }

}

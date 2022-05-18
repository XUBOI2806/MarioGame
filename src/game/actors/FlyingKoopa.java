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

public class FlyingKoopa extends Koopa implements Speakable{

    public FlyingKoopa(){
        super();
        this.setDisplayChar('F');
        this.resetMaxHp(150);
        this.addCapability(Status.FLY);
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
    public List<Monologue> sentences(Actor target) {
        ArrayList<Monologue> sentenceList = new ArrayList<>();
        sentenceList.add(new Monologue(this, "Pam pam pam!"));
        return sentenceList;
    }


}

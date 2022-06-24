package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actions.EndGameAction;
import game.actions.SpeakAction;
import game.actors.monologue.Monologue;
import game.actors.monologue.Speakable;
import game.items.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Princess Peach actor!
 */
public class PrincessPeach extends Actor implements Speakable {

    /**
     * Constructor
     */
    public PrincessPeach(){
        super("Princess Peach",'P', 1);
    }

    /**
     * Choose an action to be performed by Peach
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return an action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        if (this.hasCapability(Status.TALK)){
            this.removeCapability(Status.TALK);
            String monologue = new SpeakAction(this).execute(this, map);
            display.println(monologue);
        }
        else{
            this.addCapability(Status.TALK);
        }

        return new DoNothingAction();
    }

    /**
     * Returns a collection of actions that another actor might perform on Peach
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a collection of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if(otherActor.hasCapability(Status.HAS_PEACH_KEY)){
            actions.add(new EndGameAction(otherActor));
        }
        return actions;
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
        sentenceList.add(new Monologue(this, "Dear Mario, I'll be waiting for you..."));
        sentenceList.add(new Monologue(this, "Never gonna give you up!"));
        sentenceList.add(new Monologue(this, "Release me, or I will kick you!"));
        return sentenceList;
    }

}

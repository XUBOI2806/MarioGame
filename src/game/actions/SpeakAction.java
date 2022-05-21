package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Monologue;
import game.actors.Speakable;
import game.actors.Status;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;


/**
 * Action to allow speaking
 */
public class SpeakAction extends Action {

    /**
     * The Actor that will talk
     */
    protected Speakable speaker;

    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     * @param speaker The Actor to talk
     */
    public SpeakAction(Speakable speaker) {
        this.speaker = speaker;
    }

    /**
     * Prints the sentence that the target will say
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the target's sentence to display in the UI.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        List<Monologue> list = speaker.sentences(actor);

        int i = rand.nextInt(list.size());

        while (!list.get(i).isCanSpeak()) {
            i = rand.nextInt(list.size());
        }

        String statement = list.get(i).getSentence();

        return speaker + ": \"" + statement + "\"";
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the rock"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks with " + speaker;
    }

    @Override
    public Action getNextAction() {
        return super.getNextAction();
    }
}

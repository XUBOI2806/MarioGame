package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Action to allow speaking
 */
public class SpeakAction extends Action {

    /**
     * The Actor that will talk
     */
    protected Actor target;

    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     * @param target The Actor to talk
     */
    public SpeakAction(Actor target) {
        this.target = target;
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
        String statement;
        statement = getStatement(actor);
        return "Toad: \"" + statement + "\"";
    }

    /**
     * Returns a random statement that the target will return
     * depending on the actor's conditions
     *
     * @param actor the Actor to talk
     */
    public String getStatement(Actor actor, ArrayList<String> monologues){
        int i = rand.nextInt(monologues.size());
        return monologues.get(i);
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
        return actor + " talks with " + target;
    }
}

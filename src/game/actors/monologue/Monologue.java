package game.actors.monologue;

import edu.monash.fit2099.engine.actors.Actor;


/**
 * A class that can determine which sentences that speakers may return depending on whether it can return it or not
 */
public class Monologue {

    private Actor actor;
    private String sentence;
    private boolean canSpeak;

    /**
     * Constructor.
     *
     * @param actor The Actor to talk
     * @param sentence The sentence that the actor can say
     */
    public Monologue(Actor actor, String sentence) {
        this.actor = actor;
        this.sentence = sentence;
        this.canSpeak = true;
    }

    /**
     * Constructor.
     *
     * @param actor The Actor to talk
     * @param sentence The sentence that the actor can say
     * @param canSpeak Checks whether the actor can say the sentence or not
     */
    public Monologue(Actor actor, String sentence, Boolean canSpeak) {
        this.actor = actor;
        this.sentence = sentence;
        this.canSpeak = canSpeak;
    }

    /**
     * Determines whether the sentence can be displayed or not
     * @return a boolean value
     */
    public boolean isCanSpeak() {
        return canSpeak;
    }

    /**
     * Returns the sentence
     * @return a String of the sentence
     */
    public String getSentence() {
        return sentence;
    }

}

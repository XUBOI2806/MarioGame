package game.actors.monologue;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.List;

public interface Speakable {

    /**
     * Returns a collection of the statements that the current Actor can say from the target's conditions.
     *
     * @param target the Actor's conditions that need to be checked
     * @return A collection of sentences.
     */
    List<Monologue> sentences(Actor target);
}


package game.actors.koopa;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Status;
import game.actors.monologue.Monologue;
import game.actors.monologue.Speakable;

import java.util.ArrayList;
import java.util.List;

/**
 * Flying version of Koopa.
 */
public class FlyingKoopa extends Koopa implements Speakable {

    /**
     * Constructor
     */
    public FlyingKoopa(){
        super();
        this.setDisplayChar('F');
        this.resetMaxHp(150);
        this.addCapability(Status.FLY);
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
        sentenceList.add(new Monologue(this, "Pam pam pam!"));
        return sentenceList;
    }


}

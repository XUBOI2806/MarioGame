package game.actors;

import edu.monash.fit2099.engine.actors.Actor;

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
    public List<Monologue> sentences(Actor target) {
        ArrayList<Monologue> sentenceList = new ArrayList<>();
        sentenceList.add(new Monologue(this, "Pam pam pam!"));
        return sentenceList;
    }


}

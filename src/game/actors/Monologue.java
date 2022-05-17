package game.actors;

import edu.monash.fit2099.engine.actors.Actor;

public class Monologue {
    private Actor target;

    private String sentence;

    private boolean canSpeak;

    public Monologue(Actor actor, String sentence) {
        this.target = actor;
        this.sentence = sentence;
        this.canSpeak = true;
    }

    public Monologue(Actor actor, String sentence, Boolean canSpeak) {
        this.target = actor;
        this.sentence = sentence;
        this.canSpeak = canSpeak;
    }

    public boolean isCanSpeak() {
        return canSpeak;
    }

    public String getSentence() {
        return sentence;
    }

}

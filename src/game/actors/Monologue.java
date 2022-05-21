package game.actors;

import edu.monash.fit2099.engine.actors.Actor;

public class Monologue {
    private Actor actor;

    private String sentence;

    private boolean canSpeak;

    public Monologue(Actor actor, String sentence) {
        this.actor = actor;
        this.sentence = sentence;
        this.canSpeak = true;
    }

    public Monologue(Actor actor, String sentence, Boolean canSpeak) {
        this.actor = actor;
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

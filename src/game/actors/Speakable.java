package game.actors;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.List;

public interface Speakable {

    List<Monologue> sentences(Actor target);

}


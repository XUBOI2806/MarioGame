package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.List;

public interface Speakable {

    List<Monologue> sentences(Actor target);

    Action nextAction();
}


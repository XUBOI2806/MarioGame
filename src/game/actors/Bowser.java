package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.Behaviour;
import game.items.PeachKey;
import game.items.SuperMushroom;

import java.util.HashMap;
import java.util.Map;

public class Bowser extends Actor {
    // Attributes
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    // Constructor
    public Bowser(){
        super("Bowser",'B',500);
        this.addCapability(Status.FIRE);
        this.addItemToInventory(new PeachKey());
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }
}

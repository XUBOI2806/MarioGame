package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 * Toad
 */
public class Toad extends Actor  {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour


    public Toad() {
        super("Toad", 'o', 0);
        this.behaviours.put(10, new WanderBehaviour());
        this.addCapability(Status.FRIENDLY);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        return menu.showMenu(this, actions, display);
    }

    @Override
    public char getDisplayChar(){
        return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
    }
}


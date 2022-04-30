package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SpeakAction;
import game.actions.TradeAction;
import game.behaviours.WanderBehaviour;
import game.behaviours.Behaviour;
import game.items.PowerStar;
import game.items.SuperMushroom;
import game.items.Utils;
import game.items.Wrench;

import java.util.HashMap;
import java.util.Map;

/**
 * Toad
 */
public class Toad extends Actor {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour


    public Toad() {
        super("Toad", 'o', 0);
        this.behaviours.put(10, new WanderBehaviour());
        this.addCapability(Status.FRIENDLY);
        this.addItemToInventory(new PowerStar());
        this.addItemToInventory(new SuperMushroom());
        this.addItemToInventory(new Wrench());
    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList list = super.allowableActions(otherActor, direction, map);
        list.add(new TradeAction(new PowerStar(), Utils.POWER_STAR_PRICE));
        list.add(new TradeAction(new SuperMushroom(), Utils.SUPER_MUSHROOM_PRICE));
        list.add(new TradeAction(new Wrench(), Utils.WRENCH_PRICE));
        list.add(new SpeakAction(this));
        return list;
    }
}



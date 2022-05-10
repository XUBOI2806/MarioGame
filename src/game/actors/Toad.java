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
 * Class representing Toad.
 */
public class Toad extends Actor implements Speakable{
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    /**
     * Constructor.
     *
     */
    public Toad() {
        super("Toad", 'O', 0);
        this.behaviours.put(10, new WanderBehaviour());
        this.addItemToInventory(new PowerStar());
        this.addItemToInventory(new SuperMushroom());
        this.addItemToInventory(new Wrench());
    }

    /**
     * Figure out what to do next.
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
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

    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList list = super.allowableActions(otherActor, direction, map);
        list.add(new TradeAction(new PowerStar(), Utils.POWER_STAR_PRICE));
        list.add(new TradeAction(new SuperMushroom(), Utils.SUPER_MUSHROOM_PRICE));
        list.add(new TradeAction(new Wrench(), Utils.WRENCH_PRICE));
        list.add(new SpeakAction(this));
        return list;
    }

    /**
     * Returns a random statement that the target will return
     * depending on the actor's conditions
     *
     * @param actor the Actor to talk
     */

    @Override
    public String spokenBy(Actor actor) {}

}




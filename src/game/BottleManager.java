package game;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Drinker;
import game.actors.Status;
import game.grounds.Fountain;
import game.items.Water;

import javax.swing.plaf.ActionMapUIResource;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * A global Singleton manager that holds balances of Actors
 */
public class BottleManager {

    /**
     * A singleton reset manager instance
     */
    private static BottleManager instance;

    /**
     * A HashMap of the actor and it's respective balance as an integer
     */
    private Map<Actor, Stack<Water>> waterStackMap;

    /**
     * Constructor
     */
    private BottleManager() {
        this.waterStackMap = new HashMap<>();
    }

    /**
     * Get the singleton instance of reset manager
     * @return ResetManager singleton instance
     */
    public static BottleManager getInstance() {
        if (instance == null) {
            instance = new BottleManager();
        }
        return instance;
    }

    /**
     * Checks if the actor is a part of the Hashmap yet. If not, it adds the actor and
     * sets a value of 0 as the balance for the actor.
     *
    * @param actor The balance of the Actor
     */
    public void check(Actor actor){
        if (!this.waterStackMap.containsKey(actor)){
            if (actor.hasCapability(Status.HAS_BOTTLE)){
                this.waterStackMap.put(actor,new Stack<>());
            }
        }
    }

    /**
     * Adds a value on top of the Actor's current balance
     *
     * @param actor The balance of the Actor
     */
    public void addWater(Actor actor, Fountain fountain){
        this.check(actor);
        Stack waterStack = this.waterStackMap.get(actor);
        waterStack.push(new Water(fountain));
        this.waterStackMap.put(actor, waterStack);
    }

    /**
     * Gets the current value of the Actor's balance
     *
     * @param actor The balance of the Actor
     */
    public Stack returnWaterStack(Actor actor) {
        this.check(actor);
        Stack waterStack = new Stack<Water>();
        for (Water water : this.waterStackMap.get(actor)){
            waterStack.push(water.string());
        }
        return waterStack;
    }

    /**
     * Deducts a value on top of the Actor's current balance
     *
     * @param actor The balance of the Actor
     */
    public Water useWater(Actor actor) {
        this.check(actor);
        Stack<Water> waterStack = this.waterStackMap.get(actor);
        Water water = null;
        if (!waterStack.isEmpty()) {
            water = waterStack.pop();
            water.useBuff((Drinker) actor);
            this.waterStackMap.put(actor, waterStack);
        }
        return water;
    }

    public int length(Actor actor){
        this.check(actor);
        Stack<Water> waterStack = this.waterStackMap.get(actor);
        return waterStack.size();
    }
}


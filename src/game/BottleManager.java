package game;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Status;
import game.items.Water;

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
    private Map<Actor, Stack<Water>> waterStack;

    /**
     * Constructor
     */
    private BottleManager() {
        this.waterStack = new HashMap<>();
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
        if (!this.waterStack.containsKey(actor)){
            actor.hasCapability(Status.HAS_BOTTLE);
            this.waterStack.put(actor,new Stack<>());
        }
    }

    /**
     * Adds a value on top of the Actor's current balance
     *
     * @param actor The balance of the Actor
     * @param value The value being added
     */
    public void addWater(Actor actor, Water water){
        this.check(actor);
        Stack waterStack = this.waterStack.get(actor);
        waterStack.push(water);
        this.waterStack.put(actor, waterStack);
    }

    /**
     * Gets the current value of the Actor's balance
     *
     * @param actor The balance of the Actor
     */
    public Stack getWaterStack(Actor actor) {
        this.check(actor);
        return this.waterStack.get(actor);
    }

    /**
     * Deducts a value on top of the Actor's current balance
     *
     * @param actor The balance of the Actor
     * @param value The value being deducted
     */
    public Water useWater(Actor actor) {
        this.check(actor);
        Stack<Water> waterStack = this.waterStack.get(actor);
        Water water = null;
        if (!waterStack.isEmpty()) {
            water = waterStack.pop();
            this.waterStack.put(actor, waterStack);
        }
        return water;
    }
}


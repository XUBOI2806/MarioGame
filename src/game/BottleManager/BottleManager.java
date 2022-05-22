package game.BottleManager;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Drinker;
import game.actors.Status;
import game.grounds.fountains.Fountain;
import game.items.Water;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * A global Singleton manager that holds bottles of Actors
 */
public class BottleManager {

    /**
     * A singleton Bottle manager instance
     */
    private static BottleManager instance;

    /**
     * A HashMap of the actor and it's respective Stack of Water
     */
    private Map<Actor, Stack<Water>> waterStackMap;

    /**
     * Constructor
     */
    private BottleManager() {
        this.waterStackMap = new HashMap<>();
    }

    /**
     * Get the singleton instance of bottle manager
     * @return BottleManager singleton instance
     */
    public static BottleManager getInstance() {
        if (instance == null) {
            instance = new BottleManager();
        }
        return instance;
    }

    /**
     * Checks if the actor is a part of the Hashmap yet. If not, it checks the actor of its capabilities
     * and sets a new Stack for the actor if true.
     *
     * @param actor The Stack of the Actor
     */
    public void check(Actor actor){
        if (!this.waterStackMap.containsKey(actor)){
            if (actor.hasCapability(Status.HAS_BOTTLE)){
                this.waterStackMap.put(actor,new Stack<>());
            }
        }
    }

    /**
     * Adds Water to the Actor's current Stack
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
     * Gets the current Actor's current Stack of Water
     *
     * @param actor The Stack of the Actor
     * @return A stack of the Water
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
     * Returns the Water from the Actor's current Stack
     *
     * @param actor The Stack of the Actor
     * @return the Water that will be used
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

    /**
     * Returns length of the Actor's current Stack
     *
     * @param actor The Stack of the Actor
     * @return the length of the Stack
     */
    public int length(Actor actor){
        this.check(actor);
        Stack<Water> waterStack = this.waterStackMap.get(actor);
        return waterStack.size();
    }
}


package game.wallet;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;
import java.util.Map;

/**
 * A global Singleton manager that holds balances of Actors
 */
public class WalletManager {

    /**
     * A singleton reset manager instance
     */
    private static WalletManager instance;

    /**
     * A HashMap of the actor and it's respective balance as an integer
     */
    private Map<Actor, Integer> balances;

    /**
     * Constructor
     */
    private WalletManager() {
        this.balances = new HashMap<>();
    }

    /**
     * Get the singleton instance of reset manager
     * @return ResetManager singleton instance
     */
    public static WalletManager getInstance() {
        if (instance == null) {
            instance = new WalletManager();
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
        if (!this.balances.containsKey(actor)){
            this.balances.put(actor,1000);
        }
    }

    /**
     * Adds a value on top of the Actor's current balance
     *
     * @param actor The balance of the Actor
     * @param value The value being added
     */
    public void addBalance(Actor actor, int value){
        this.check(actor);
        int balance = this.balances.get(actor);
        balance+=value;
        this.balances.put(actor, balance);
    }

    /**
     * Gets the current value of the Actor's balance
     *
     * @param actor The balance of the Actor
     */
    public int getBalance(Actor actor) {
        this.check(actor);
        return this.balances.get(actor);
    }

    /**
     * Deducts a value on top of the Actor's current balance
     *
     * @param actor The balance of the Actor
     * @param value The value being deducted
     */
    public void deductBalance(Actor actor, int value){
        this.check(actor);
        int balance = this.balances.get(actor);
        if (balance >= value){
            balance -= value;
            this.balances.put(actor, balance);
        }
    }
}


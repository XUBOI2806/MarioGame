package game.wallet;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;
import java.util.Map;

public class WalletManager {
    private static WalletManager instance;
    private Map<Actor, Integer> balances;

    private WalletManager() {
        this.balances = new HashMap<>();
    }

    public static WalletManager getInstance() {
        if (instance == null) {
            instance = new WalletManager();
        }
        return instance;
    }

    public void check(Actor actor){
        if (this.balances.containsKey(actor)){
            //Do nothing
        }
        else{
            this.balances.put(actor,0);
        }
    }

    public void addBalance(Actor actor, int value){
        this.check(actor);
        int balance = this.balances.get(actor);
        balance+=value;
        this.balances.put(actor, balance);
    }

    public int getBalance(Actor actor) {
        this.check(actor);
        return this.balances.get(actor);
    }

    public void deductBalance(Actor actor, int value){
        this.check(actor);
        int balance = this.balances.get(actor);
        if (balance>=value){
            balance -= value;
            this.balances.put(actor, balance);
        }
        else{
            // Do nothing
        }
    }



}


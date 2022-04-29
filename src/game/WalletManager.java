package game;

import edu.monash.fit2099.engine.actors.Actor;

public class WalletManager {
    private Actor actor;
    private int balance;

    private static WalletManager instance;

    private WalletManager(Actor actor) {
        this.balance = 0;
        this.actor = actor;
    }

    public static WalletManager getInstance(Actor actor) {
        if (instance == null) {
            instance = new WalletManager(actor);
        }
        return instance;
    }

    public void addBalance(Actor actor, int value){
        this.balance += value;
    }

    public int getBalance(Actor actor) {
        return this.balance;
    }

    public void deductBalance(Actor actor, int value){
        if (this.balance>=value){
            this.balance -= value;
        }
        else{
            // Do nothing
        }
    }
}


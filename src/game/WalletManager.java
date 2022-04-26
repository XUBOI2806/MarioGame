package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.actors.Actor;
import game.items.Coin;

import java.security.PublicKey;

public class WalletManager {
    private int balance;

    private static WalletManager instance;

    private WalletManager() {
        balance = 0;
    }

    public static WalletManager getInstance() {
        if (instance == null) {
            instance = new WalletManager();
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


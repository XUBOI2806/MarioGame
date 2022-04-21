package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.actors.Actor;
import game.items.Coin;

public class WalletManager {

    private int balance;
    protected Coin coin;

    public WalletManager() {
        this.balance = 0;
    }

    public int getBalance(Actor actor) {
        for (Item item: actor.getInventory()){
            if (item == coin){
                balance += coin.getValue();
            }
        }
        return balance;
    }

    public void deductBalance(Actor actor, int value){
        balance = this.getBalance(actor);
        if (balance>=value){
            int newBalance = balance - value;
            for (Item item: actor.getInventory()){
                if (item == coin){
                    balance -= coin.getValue();
                    actor.removeItemFromInventory(item);
                    if (balance<newBalance){
                        break;
                    }
                }
            }
            int coinValue = newBalance - balance;
            Coin change = new Coin(coinValue);
            actor.addItemToInventory(change);
        }
        else{
            // Do nothing
        }
    }
}


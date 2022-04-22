package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.WalletManager;

public class Coin extends Item {
    private int value;

    public Coin(int value) {
        super("Coin", '$', Boolean.parseBoolean("True"));
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }


    public PickUpItemAction getPickUpAction(Actor actor) {
        WalletManager.getInstance().addBalance(this.getValue());
        return super.getPickUpAction(actor);
        // actor.removeItemFromInventory(this);
    }

}

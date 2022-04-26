package game.items;

import edu.monash.fit2099.engine.items.Item;


public class Coin extends Item {
    private int value;

    public Coin(int value) {
        super("Coin", '$', Boolean.parseBoolean("False"));
        this.value = value;
        this.addAction(new PickUpCoinAction(this));
    }

    public int getValue() {
        return this.value;
    }
}

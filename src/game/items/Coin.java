package game.items;

import edu.monash.fit2099.engine.items.Item;

public class Coin extends Item {
    private int value;

    public Coin(int value) {
        super("Coin", '$', Boolean.parseBoolean("True"));
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

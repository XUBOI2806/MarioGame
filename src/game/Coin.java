package game;

import edu.monash.fit2099.engine.items.Item;

public class Coin extends Item {
    private int value;

    public Coin(String name, char displayChar, boolean portable, int value) {
        super(name, displayChar, portable);
        this.value = value;
    }

}

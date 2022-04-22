package game.items;

import edu.monash.fit2099.engine.items.Item;

public class SuperMushroom extends Item implements Purchasable{
    int price;

    public SuperMushroom() {
        super("Super Mushroom", '^', Boolean.parseBoolean("True"));
    }

    @Override
    public int price() {
        return 400;
    }
}

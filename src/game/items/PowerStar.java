package game.items;

import edu.monash.fit2099.engine.items.Item;

public class PowerStar extends Item implements Purchasable{
    int price;

    public PowerStar() {
        super("Power Star", '*', Boolean.parseBoolean("True"));
    }

    @Override
    public int price() {
        return 600;
    }
}

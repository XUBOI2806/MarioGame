package game.items;

import edu.monash.fit2099.engine.items.Item;

public class PowerStar extends Item{
    int price;

    public PowerStar() {
        super("Power Star", '*', Boolean.parseBoolean("True"));
    }

}

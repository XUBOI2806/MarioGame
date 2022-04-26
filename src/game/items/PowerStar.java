package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public class PowerStar extends Item implements Purchasable {
    int price;

    public PowerStar() {
        super("Power Star", '*', Boolean.parseBoolean("True"));
    }

    public void add_item(Actor actor){
    }

}


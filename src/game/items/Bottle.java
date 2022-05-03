package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Stack;


/**
 * Class representing the item Bottle.
 */
public class Bottle extends Item{

    private final Stack <MagicalWater> stack= new Stack<>();

    /**
     * Constructor.
     *
     * @param value The value of the item Coin
     */
    public Bottle() {
        super("Bottle", 'B', Boolean.parseBoolean("False"));

    }


}

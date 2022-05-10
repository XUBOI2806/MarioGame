package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.Fountains;

import java.util.Stack;


/**
 * Class representing the item Bottle.
 */
public class Bottle extends Item{

    private final Stack <String> stack= new Stack<>();

    /**
     * Constructor.
     *
     */
    public Bottle() {
        super("Bottle", 'B', Boolean.parseBoolean("False"));
    }

    /**
     *
     */
    public void getWater(Actor actor, Fountains fountain) {
        this.stack.push(fountain.getWater());
    }

    public void useBottle(Actor actor) {
        String water = this.stack.pop();
    }



}

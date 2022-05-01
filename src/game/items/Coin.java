package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.reset.Resettable;

import java.util.ArrayList;


public class Coin extends Item implements Resettable {
    private int value;

    public Coin(int value) {
        super("Coin", '$', Boolean.parseBoolean("False"));
        this.value = value;
        this.addAction(new PickUpCoinAction(this));
        registerInstance();
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public void resetInstance() {
        this.addCapability(Status.REMOVE);
    }

    @Override
    public void tick(Location currentLocation) {
        if (this.hasCapability(Status.REMOVE)) {
            currentLocation.removeItem(this);
        }
    }
}

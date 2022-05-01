package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.reset.ResetManager;
import game.reset.Resettable;


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
        this.addCapability(Status.RESET);
    }

    @Override
    public void tick(Location currentLocation) {
        if (this.hasCapability(Status.RESET)) {
            currentLocation.removeItem(this);
            ResetManager.getInstance().cleanUp(this);
        }
    }
}

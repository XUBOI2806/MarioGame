package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PickUpCoinAction;
import game.actors.Status;
import game.reset.ResetManager;
import game.reset.Resettable;

/**
 * Class representing the item Coin.
 */
public class Coin extends Item implements Resettable {

    /**
     * An integer value
     */
    private int value;

    /**
     * Constructor.
     *
     * @param value The value of the item Coin
     */
    public Coin(int value) {
        super("Coin", '$', Boolean.parseBoolean("False"));
        this.value = value;
        this.addAction(new PickUpCoinAction(this));
        registerInstance();
    }
    /**
     * Returns the value of the coin
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which the coin lie.
     */
    @Override
    public void tick(Location currentLocation) {
        if (this.hasCapability(Status.RESET)) {
            currentLocation.removeItem(this);
            ResetManager.getInstance().cleanUp(this);
        }
    }

    /**
     * Allows any classes that use this interface to reset abilities, attributes, and/or items.
     */
    @Override
    public void resetInstance() {
        this.addCapability(Status.RESET);
    }


}

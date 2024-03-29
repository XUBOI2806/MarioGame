package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Coin;
import game.wallet.WalletManager;
import game.reset.ResetManager;

/**
 * Action to allow Coins to be picked up.
 */
public class PickUpCoinAction extends Action {

    /**
     * A coin class
     */
    private final Coin coin;

    /**
     * Constructor.
     *
     * @param coin  the coin to pick up
     */
    public PickUpCoinAction(Coin coin) {
        this.coin = coin;
    }

    /**
     * Adds the value of the coin to the Actor's virtual wallet and removes the
     * coin from the map.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The Actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        WalletManager.getInstance().addBalance(actor, coin.getValue());
        map.locationOf(actor).removeItem(coin);
        ResetManager.getInstance().cleanUp(coin);
        return menuDescription(actor);

    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the rock"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the Coin ($" + coin.getValue() + ")";
    }
}

package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.WalletManager;
import game.actions.AttackAction;
import game.actions.ResetAction;
import game.items.Coin;
import game.items.Wrench;
import game.reset.Resettable;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();
	private GameMap map;
	private WalletManager walletManager;
	private boolean runExcecuted = false;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints, GameMap map) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.FLOOR);
		this.map = map;
		registerInstance();
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		if (!runExcecuted) {
			actions.add(new ResetAction());
			runExcecuted = true;
		}
		// return/print the console menu
		display.println("Mario: " + this.printHp() + " at ("+ this.map.locationOf(this).x() + "," + this.map.locationOf(this).y() +")");
		display.println("Wallet: $" + walletManager.getInstance().getBalance(this));
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	@Override
	public void resetInstance() {
		this.resetMaxHp(this.getMaxHp());
		this.removeCapability(Status.TALL);
		this.removeCapability(Status.INVINCIBLE);
	}
}

package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.DrinkWaterAction;
import game.items.*;
import game.wallet.WalletManager;
import game.actions.ResetAction;
import game.reset.Resettable;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable, Drinker {

	private final Menu menu = new Menu();
	private GameMap map;
	private WalletManager walletManager;

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
		this.addCapability(Status.RESET);
		this.addItemToInventory(new Bottle());
		this.map = map;
		registerInstance();
	}

	/**
	 * Determines an action that the player can take depending on statuses and surroundings
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return An action the player has selected
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		if (this.hasCapability(Status.RESET)) {
			actions.add(new ResetAction());
		}
		if (this.hasCapability(Status.HAS_BOTTLE)){
			actions.add(new DrinkWaterAction());
		}

		// return/print the console menu
		display.println("Mario: " + this.printHp() + " at ("+ this.map.locationOf(this).x() + "," + this.map.locationOf(this).y() +")");
		display.println("Wallet: $" + WalletManager.getInstance().getBalance(this));
		if (this.hasCapability(Status.INVINCIBLE)){
			display.println("Mario is INVINCIBLE");
		}
		return menu.showMenu(this, actions, display);
	}

	/**
	 * Display character of player
	 * @return 'm' for the player, 'M' for the TALL status
	 */
	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	/**
	 * Allows any classes that use this interface to reset abilities, attributes, and/or items.
	 */
	@Override
	public void resetInstance() {
		this.resetMaxHp(this.getMaxHp());
		this.removeCapability(Status.TALL);
		this.removeCapability(Status.INVINCIBLE);
	}

	@Override
	public void fountainIncreaseAttack(int attack) {
		int damage = this.getIntrinsicWeapon().damage();
		damage += attack;
	}


	@Override
	public void fountainHeal(int health) {
		this.heal(health);
	}
}

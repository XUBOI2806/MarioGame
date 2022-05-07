package game.grounds;
import edu.monash.fit2099.engine.positions.Ground;



/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {
	/**
	 * Enum to add Fertile capability to the dirt
	 */
	public enum State{
		FERTILE //Shows that dirt is fertile for sprout to grow
	}

	/**
	 * Constructor
	 */
	public Dirt() {
		super('.');
		this.addCapability(State.FERTILE);
	}



}

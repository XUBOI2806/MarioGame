package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Coin;
import game.items.Wrench;

import java.util.Random;

public class SpeakAction extends Action {

    /**
     * Create a class of toad
     */
    protected Actor target;
    protected Coin coin;

    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     */
    public SpeakAction(Actor target) {
        this.target = target;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        int i = rand.nextInt(4);
        String statement = null;
        switch(i) {
            case 1:
                if (actor.getInventory().contains(new Wrench())){
                    this.execute(actor, map);
                }
                else{
                    statement = "You might need a wrench to smash Koopa's hard shells.";
                }
                break;
            case 2:
                if (actor.capabilitiesList().contains("INVINCIBLE")){
                    this.execute(actor, map);
                }
                else{
                    statement ="You better get back to finding the Power Stars.";
                }
                break;
            case 3:
                statement = "The Princess is depending on you! You are our only hope.";
                break;
            case 4:
                statement = "Being imprisoned in these walls can drive a fungus crazy :(";
                break;
        }
        return statement;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks with " + target;
    }
}

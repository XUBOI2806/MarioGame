package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.attack.AttackAction;
import game.actions.SpeakAction;
import game.actors.monologue.Monologue;
import game.actors.monologue.Speakable;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.items.PeachKey;
import game.items.Utils;
import game.reset.ResetManager;
import game.reset.Resettable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bowser actor!
 */
public class Bowser extends Enemy implements Resettable, Speakable {
    // Attributes
    private int damage;

    /**
     * Constructor
     */
    public Bowser(){
        super("Bowser",'B',500);
        this.addCapability(Status.FIRE);
        this.addItemToInventory(new PeachKey());
        registerInstance();
        this.damage = Utils.BOWSER_BASE_DMG;
    }

    /**
     * Checks the other actor and adds behaviours to Bowser.
     * @param otherActor the other actor
     * @param direction the direction of the other actor
     * @param map current gameMap
     * @return ActionList of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            if(!behaviours.containsKey(9)) {
                this.behaviours.put(9, new FollowBehaviour(otherActor));
            }
        }
        return super.allowableActions(otherActor, direction, map);
    }

    /**
     * Choosing an action to perform
     * @param actions collection of possible actions for the actor
     * @param lastAction the last action the actor performed
     * @param map gameMap with the actor
     * @param display I/O of the message
     * @return an action that has been chosen to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.RESET)) {
            this.behaviours.clear();
            map.removeActor(this);
            ResetManager.getInstance().cleanUp(this);
        }

        if (this.hasCapability(Status.TALK)){
            this.removeCapability(Status.TALK);
            String monologue = new SpeakAction(this).execute(this, map);
            display.println(monologue);
        }
        else{
            this.addCapability(Status.TALK);
        }

        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * Creates and returns an intrinsic weapon.
     *
     * The Actor 'punches' for damage that might be changed.
     *
     * @return an IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(this.damage,"punch");
    }

    /**
     * Adding the Status Reset
     */
    @Override
    public void resetInstance(){
        this.addCapability(Status.RESET);
    }


    /**
     * Returns a collection of the statements that the current Actor can say from the target's conditions.
     *
     * @param target the Actor's conditions that need to be checked
     * @return A collection of sentences.
     */
    @Override
    public List<Monologue> sentences(Actor target) {
        ArrayList<Monologue> sentenceList = new ArrayList<>();
        sentenceList.add(new Monologue(this, "What was that sound? Oh, just a fire."));
        sentenceList.add(new Monologue(this, "Princess Peach! You are formally invited... to the creation of my new kingdom!"));
        sentenceList.add(new Monologue(this, "Never gonna let you down!"));
        sentenceList.add(new Monologue(this, "Wrrrrrrrrrrrrrrrryyyyyyyyyyyyyy!!!!"));
        return sentenceList;
    }

}

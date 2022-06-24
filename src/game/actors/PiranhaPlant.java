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
import game.reset.Resettable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Piranha plant that sits on top of a WarpPipe
 */
public class PiranhaPlant extends Enemy implements Speakable, Resettable {
    /**
     * Constructor.
     *
     */
    public PiranhaPlant() {
        super("Piranha Plant",'Y',150);
        this.addCapability(Status.PIRANHAPLANT);
        registerInstance();
    }

    /**
     * Returns a collection of actions another actor can do on Piranha Plant
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a collection of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        return actions;
    }

    /**
     * Chooses an action that the enemy will perform
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return an action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(this.hasCapability(Status.RESET) && this.isConscious()){
            this.behaviours.clear();
            this.increaseMaxHp(50);
            this.removeCapability(Status.RESET);

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
     * Returns a collection of the statements that the current Actor can say from the target's conditions.
     *
     * @param target the Actor's conditions that need to be checked
     * @return A collection of sentences.
     */
    @Override
    public List<Monologue> sentences(Actor target) {
        ArrayList<Monologue> sentenceList = new ArrayList<>();
        sentenceList.add(new Monologue(this, "Slsstssthshs~! (Never gonna say goodbye~)"));
        sentenceList.add(new Monologue(this, "Ohmnom nom nom nom."));
        return sentenceList;
    }

    /**
     * Gets the intrinsic weapon for Piranha Plant
     * @return an intrinsic weapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(90, "chomps");
    }

    /**
     * Adds the reset capability
     */
    @Override
    public void resetInstance() {
        this.addCapability(Status.RESET);
    }
}


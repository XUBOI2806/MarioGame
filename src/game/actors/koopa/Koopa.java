package game.actors.koopa;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.RemoveDormantActorAction;
import game.actions.SpeakAction;
import game.actors.Drinker;
import game.actors.Enemy;
import game.actors.Status;
import game.actors.monologue.Monologue;
import game.actors.monologue.Speakable;
import game.behaviours.*;
import game.grounds.fountains.Fountain;
import game.items.SuperMushroom;
import game.items.Utils;
import game.reset.ResetManager;
import game.reset.Resettable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Koopa actor
 */
public abstract class Koopa extends Enemy implements Resettable, Speakable, Drinker {
    // Attributes
    private int damage;

    /**
     * Constructor for Koopa.
     */
    public Koopa() {
        super("Koopa", 'K', 100);
        this.behaviours.put(10, new WanderBehaviour());
        this.addItemToInventory(new SuperMushroom());
        this.addCapability(Status.DORMANT_ABLE);
        registerInstance();
        damage = Utils.KOOPA_BASE_DMG;
    }

    /**
     * Decides the actions that another actor can perform. Also decides to put in specific behaviours when the other
     * actor is hostile. Also decides when another actor can remove the dormant koopa.
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && this.isConscious()) {
            actions = super.allowableActions(otherActor,direction,map);
            if(!behaviours.containsKey(8)){
                this.behaviours.put(8, new FollowBehaviour(otherActor));
            }
        }
        else if (otherActor.hasCapability(Status.WRENCH)) {
            actions.add(new RemoveDormantActorAction(this, direction));
        }
        return actions;
    }

    /**
     * playTurn decides what action the Koopa should do next complicit with the behaviours.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return an action the koopa can perform, if it cannot do anything just DoNothingAction
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(map.locationOf(this).getGround().hasCapability(Status.FOUNTAIN)){
            this.behaviours.put(9, new DrinkBehaviour((Fountain) map.locationOf(this).getGround()));
        }
        else{
            this.behaviours.remove(9);
        }


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
     * Gives the display character
     * @return 'K' if not dormant, 'D' if dormant
     */
    @Override
    public char getDisplayChar() {
        if (this.hasCapability(Status.DORMANT)) {
            super.setDisplayChar('D');
            return super.getDisplayChar();
        }
        return super.getDisplayChar();
    }


    /**
     * Allows any classes that use this interface to reset abilities, attributes, and/or items.
     */
    @Override
    public void resetInstance() {
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
        sentenceList.add(new Monologue(this, "Never gonna make you cry!"));
        sentenceList.add(new Monologue(this, "Koopi koopi koopii~!"));
        return sentenceList;
    }

    /**
     * Applies a buff to anyone that drinks from the Power Fountain
     *
     */
    @Override
    public void fountainIncreaseAttack(int attack) {
        this.damage += attack;
    }


    /**
     * Applies healing to anyone that drinks from the Healing Fountain
     *
     */
    @Override
    public void fountainHeal(int health) {
        this.heal(health);
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
        return new IntrinsicWeapon(this.damage,"punches");
    }
}

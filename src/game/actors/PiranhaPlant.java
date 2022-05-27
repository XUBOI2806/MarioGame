package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
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

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        return actions;
    }

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

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(90, "chomps");
    }

    @Override
    public void resetInstance() {
        this.addCapability(Status.RESET);
    }
}


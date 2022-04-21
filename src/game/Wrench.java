package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Wrench extends WeaponItem {
    // Attributes

    // Constructor
    public Wrench(String name, char displayChar, int damage, String verb, int hitRate){
        super(name,displayChar,damage,verb,hitRate);
        this.addCapability(Status.WRENCH);
    }

    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        actor.addCapability(Status.WRENCH);
        return super.getPickUpAction(actor);
    }
}

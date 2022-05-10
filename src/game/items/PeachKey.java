package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.actors.Status;

import java.util.List;

public class PeachKey extends Item {

    // Constructor
    public PeachKey(){
        super("Princess Peach Key",'k',true);
        this.addCapability(Status.PEACH);
    }



}

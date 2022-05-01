package game.actions;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.Dirt;
import game.items.Coin;

public class DestroyGroundAction extends MoveActorAction {

    public DestroyGroundAction(Location moveToLocation, String direction) {
        super(moveToLocation, direction);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        this.moveToLocation.setGround(new Dirt());
        this.moveToLocation.addItem(new Coin(5));
        return super.execute(actor, map);
    }

}

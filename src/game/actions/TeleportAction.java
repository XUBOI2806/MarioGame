package game.actions;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;

public class TeleportAction extends Action {
    protected Actor player; //the actor that will teleport in this the player

    protected String gameMap; //gameMap teleporting to

    public TeleportAction(Actor player, String gameMap){
        this.player = player;
        this.gameMap = gameMap;
    }

    @Override
    public String execute(Actor player, GameMap map){
        // give location is warp pipe and has no piranha plant
        if(map.locationOf(player).getGround().hasCapability(Status.WARPPIPE) && !map.locationOf(player).getGround().hasCapability(Status.PIRANHAPLANT)){
            Location destination = new Location(LavaGround,1,4);
            if(destination.containsAnActor()){
                map.removeActor(destination.getActor());  // removes actor on warp pipe teleported too
            }
            map.moveActor(destination); /// move to new warp pipe

    }

    @Override
    public String menuDescription(Actor player) {
        return player + " successfully teleported to " + gameMap;
    }


}

package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;
import java.util.Scanner;

public class TeleportAction extends Action {
    protected Actor player; //the actor that will teleport in this the player

    protected GameMap gameMap; //gameMap teleporting to


    public TeleportAction(Actor player, GameMap gameMap) {
        this.player = player;
        this.gameMap = gameMap;
    }

    /**
     * execute determines whether the actor has jumped to a particular terrain and if damage is taken
     * @param player The actor performing the action.
     * @param map The map the actor is on.
     * @return a string that describes which gamemap that is teleporting too
     */
    @Override
    public String execute(Actor player, GameMap map) {
        int xcord = map.locationOf(player).x(); //player's current x coord
        int ycord = map.locationOf(player).y(); //player's current y coord

        String result = "";

        // given location is warp pipe and has no piranha plant on game map
        if (map.locationOf(player).getGround().hasCapability(Status.WARPPIPE) && !map.locationOf(player).getActor().hasCapability(Status.PIRANHAPLANT)) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    Location destination = new Location(gameMap, i, j);

                    if (destination.getGround().hasCapability(Status.WARPPIPE)) { //warp pipe to teleport to
                        map.moveActor(player, destination);
                        if (destination.containsAnActor()) {
                            map.removeActor(destination.getActor());  // removes piranha plant on warp pipe teleported too
                        }
                        result += System.lineSeparator() + player + "teleport to" + gameMap;
                        break; // stop the for loop as we have already moved character
                    }
                }
            }
        }


        Scanner scan = new Scanner(System.in); // For input
        // if player wants to teleport back to previous pipe
        System.out.println("Do you wish to return to previous pipe if so type yes");
        String response = scan.nextLine(); //takes the response

        if (response.equals("Yes")) { //response is yes take it back to original pipe
            Location destination = new Location(gameMap, xcord, ycord);
            map.moveActor(player, destination);
            if (destination.containsAnActor()) {
                map.removeActor(destination.getActor());  // removes piranha plant on warp pipe teleported too
            }
            result += System.lineSeparator() + player + "teleport to" + gameMap;
        }

        return result;
    }

    /**
     * execute determines whether the actor has jumped to a particular terrain and if damage is taken
     * @param player The actor performing the teleporting.
     * returns where the players finally end up
     */
    @Override
    public String menuDescription(Actor player) {
        return player + "has finished teleporting at " + gameMap;
    }

    /**
     * execute determines next action to take
     */
    @Override
    public Action getNextAction() {
        return super.getNextAction();
    }
}

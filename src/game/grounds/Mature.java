package game.grounds;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Koopa;


public class Mature extends Tree {
    private int counter;

    public Mature() {
        super.setDisplayChar('T'); // Represent Mature as T
        counter = 0; // Counter is set to 0
    }

//    @Override
//    public void tick(Location location) { // Keep tracks of each turn
//        counter += 1; //Keep track of each iteration we increase by 1
//        if (counter % 5 == 0 && !location.containsAnActor()) { //Every 5 turns and actor not on location
//            for (int i = x - 1; i <= x + 1; i++) { // from left to right of the location
//                for (int j = y - 1; j <= y + 1; j++) { // from bottom to top of the location
//                    if (i != x && j != y) {//avoids centre piece as it's the location of the Mature
//                        if (location.getGround() == Dirt) {//location is dirt which is fertile
//                            location.setGround(new Sprout()); //location spawns a sprout
//                        }
//                    }
//                }
//            }
//        }
//        if (!location.containsAnActor()) { //Every turn as long as there isn't an actor on the location
//
//            if (Math.random() <= 0.15) { // 15% chance of spawning a Koopa
//                location.addActor(new Koopa());
//            }
//            if (Math.random() <= 0.20) { // 20% chance of
//                location.setGround(new Dirt()); // Mature withers to Dirt
//            }
//        }
//    }
}

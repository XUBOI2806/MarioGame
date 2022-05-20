package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.*;
import game.grounds.*;
import game.items.Coin;
import game.items.PowerStar;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new HealingFountain(), new LavaGround());

        List<String> map = Arrays.asList(
                "..........................................##..........+.........................",
                "............+............+..................#...................................",
                "............................................#...................................",
                ".............................................##......................+..........",
                "...............................................#................................",
                "................................................#...............................",
                ".................+................................#.............................",
                "..........................................L......##.............................",
                "................................................##..............................",
                ".........+..............................+#____####.................+............",
                ".......................................+#_____###++.............................",
                ".......................................+#______###..............................",
                "........................................+#_____###..............................",
                "........................+........................##.............+...............",
                "...................................................#............................",
                "....................................................#...........................",
                "...................+.................................#..........................",
                "......................................................#.........................",
                ".......................................................##.......................");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        Actor mario = new Player("Player", 'm', 1000, gameMap);
        world.addPlayer(mario, gameMap.at(43, 11));

        gameMap.at(44, 11).addActor(new Toad());
        gameMap.at(1,1).addActor(new PrincessPeach());

        gameMap.at(44,13).setGround(new PowerFountain());
        gameMap.at(46,13).setGround(new PowerFountain());
        gameMap.at(44,14).setGround(new PowerFountain());
        gameMap.at(45,14).setGround(new PowerFountain());
        gameMap.at(46,14).setGround(new PowerFountain());


        gameMap.at(45,13).addActor(new Koopa());
        mario.addItemToInventory(new PowerStar());
        world.run();

    }
}


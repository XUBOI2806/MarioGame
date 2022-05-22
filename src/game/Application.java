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
import game.items.PeachKey;
import game.items.PowerStar;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) {

			World world = new World(new Display());

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree());

			FancyGroundFactory lavaGround = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new Lava(), new WarpPipe());


			List<String> map = Arrays.asList(
				"..........................................##..........+.........................",
				"............+............+..................#...................................",
				"............................................#...................................",
				".............................................##......................+..........",
				"...............................................#................................",
				"................................................#...............................",
				".................+................................#.............................",
				".................................................##.............................",
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

			GameMap gameMap1 = new GameMap(lavaGround, map);
			world.addGameMap(gameMap1);


			Actor mario = new Player("Player", 'm', 100, gameMap);
			world.addPlayer(mario, gameMap.at(44, 10));

			gameMap.at(44, 11).addActor(new Toad());
			gameMap.at(44,5).addActor(new PrincessPeach(world));
			mario.addItemToInventory(new PowerStar());
			mario.addItemToInventory(new PeachKey());
			world.run();
	}
}

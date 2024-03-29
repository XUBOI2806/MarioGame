package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.*;
import game.actors.koopa.FlyingKoopa;
import game.actors.koopa.GroundKoopa;
import game.actors.koopa.Koopa;
import game.grounds.*;
import game.grounds.fountains.HealingFountain;
import game.grounds.fountains.PowerFountain;
import game.items.FireFlower;

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
				"............+............+..................#....+++............................",
				"............................................#....+.+............................",
				".............................................##..+++.................+..........",
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

		List<String> map1 = Arrays.asList(
				"C.....L.............",
				".................L..",
				"....................",
				"....................",
				".....L..............",
				"....................",
				"...........L........",
				".....L..............",
				"....................",
				"L..................."
			);


			GameMap gameMap = new GameMap(groundFactory, map);
			world.addGameMap(gameMap);

			GameMap gameMap1 = new GameMap(lavaGround, map1);
			world.addGameMap(gameMap1);


			Actor mario = new Player("Player", 'm', 100, gameMap);
			world.addPlayer(mario, gameMap.at(44, 10));

			gameMap.at(44, 11).addActor(new Toad());

			gameMap.at(1,1).addActor(new PrincessPeach());
			gameMap.at(44,8).addActor(new Bowser());

			gameMap.at(44,13).setGround(new HealingFountain());
			gameMap.at(43,13).setGround(new PowerFountain());

			gameMap.at(46,14).addActor(new GroundKoopa());
			gameMap.at(3,3).addActor(new Goomba());
			gameMap.at(5,5).addActor(new Goomba());
			gameMap.at(7,7).addActor(new Goomba());
			gameMap.at(50,2).addActor(new FlyingKoopa());
			gameMap.at(25,6).setGround(new WarpPipe());

			gameMap.at(45,10).addItem(new FireFlower());
			world.run();

	}
}

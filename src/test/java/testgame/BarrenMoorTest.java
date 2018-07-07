package testgame;

import game.manager.GameManager;
import game.player.Player;
import game.utils.Directions;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarrenMoorTest {
	private GameManager test = new GameManager();
	
	@Test
	public void testCreatePoint() {
		int[] initialPoint1 = {8, 8};
		assertTrue(Math.abs(test.createPoint(initialPoint1)[0]) <= 5 && Math.abs(test.createPoint(initialPoint1)[1]) <= 5);
	}
	
	@Test
	public void testCalcuateDistance() {
		int[] testPoint = {4, 3};
		assertEquals((float) 5, test.calculateDistance(testPoint), 0.01);
	}
	
	@Test
	public void testFindDirection() {
		int[] testPoint1 = {0, 3};
		int[] testPoint2 = {2, 2};
		int[] testPoint3 = {4, 0};
		int[] testPoint4 = {1, -1};
		int[] testPoint5 = {0, -5};
		int[] testPoint6 = {-3, -3};
		int[] testPoint7 = {-6, 0};
		int[] testPoint8 = {-2, 2};
		assertEquals(Directions.NORTH, test.findDirection(testPoint1));
		assertEquals(Directions.NORTH_EAST, test.findDirection(testPoint2));
		assertEquals(Directions.EAST, test.findDirection(testPoint3));
		assertEquals(Directions.SOUTH_EAST, test.findDirection(testPoint4));
		assertEquals(Directions.SOUTH, test.findDirection(testPoint5));
		assertEquals(Directions.SOUTH_WEST, test.findDirection(testPoint6));
		assertEquals(Directions.WEST, test.findDirection(testPoint7));
		assertEquals(Directions.NORTH_WEST, test.findDirection(testPoint8));
		
	}
	
//	@Test
//	public void testWalkNorth() {
//		int[] testPoint = {4, 3};
//		test.walk(testPoint);
//		//walk North
//		assertEquals(3, testPoint[1]);
//	}
//
//	@Test
//	public void testWalkEast() {
//		int[] testPoint = {4, 3};
//		test.walk(testPoint);
//		//walk East
//		assertEquals(3, testPoint[0]);
//	}
//
//	@Test
//	public void testWalkSouth() {
//		int[] testPoint = {4, 3};
//		test.walk(testPoint);
//		//walk South
//		assertEquals(4, testPoint[1]);
//	}
//
//	@Test
//	public void testWalkWest() {
//		int[] testPoint = {4, 3};
//		test.walk(testPoint);
//		//walk West
//		assertEquals(5, testPoint[0]);
//	}
	
	@Test
	public void testScoreCheck() {
	    Player testPlayer1 = new Player("David");
		Player testPlayer2 = new Player ("Procopis");
		testPlayer1.addPoints(10000);
		testPlayer2.addPoints(5000);

        testPlayer1.scoreCheck(testPlayer1);
		assertTrue(testPlayer1.isVictory());

        testPlayer2.scoreCheck(testPlayer2);
		assertFalse(testPlayer2.isVictory());
	}
}

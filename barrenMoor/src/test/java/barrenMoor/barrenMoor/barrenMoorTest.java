package barrenMoor.barrenMoor;

import org.junit.Test;

import junit.framework.TestCase;

public class barrenMoorTest extends TestCase {
	private Game test = new Game();
	
	@Test
	public void testCreatePoint() {
		int[] initialPoint1 = {8, 8};
		assertTrue(Math.abs(test.createPoint(initialPoint1)[0])<=5 && Math.abs(test.createPoint(initialPoint1)[1])<=5);
	}
	
	@Test
	public void testCalcuateDistance() {
		int[] testPoint = {4, 3};
		assertEquals((double)5, test.calculateDistance(testPoint));
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
		assertEquals(Directions.North, test.findDirection(testPoint1));
		assertEquals(Directions.NorthEast, test.findDirection(testPoint2));
		assertEquals(Directions.East, test.findDirection(testPoint3));
		assertEquals(Directions.SouthEast, test.findDirection(testPoint4));
		assertEquals(Directions.South, test.findDirection(testPoint5));
		assertEquals(Directions.SouthWest, test.findDirection(testPoint6));
		assertEquals(Directions.West, test.findDirection(testPoint7));
		assertEquals(Directions.NorthWest, test.findDirection(testPoint8));
		
	}
	
//	@Test
//	public void testWalkNorth() {
//		int[] testPoint = {4, 3};
//		test.walk(testPoint);
//		//walk North
//		assertEquals(3, testPoint[1]);
//		
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
		Player testPlayer1 = new Player ("David", 12000, false);
		Player testPlayer2 = new Player ("Procopis", 400, false);
		test.scoreCheck(testPlayer1);
		assertTrue(testPlayer1.victory);
		
		test.scoreCheck(testPlayer2);
		assertFalse(testPlayer2.victory);
	}
}

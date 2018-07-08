package manager;

import game.manager.GameManager;
import game.utils.Directions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameManagerTest {

    private GameManager testGame = new GameManager();

    @Test
    public void refreshPoint_shouldRefreshPointWhenTooFarFromPoint() {
        testGame.setPoint(8, 8);
        testGame.refreshPoint();
        assertTrue(testGame.getXCoord() <= 3 && testGame.getYCoord() <= 3);
    }

    @Test
    public void calculateDistance_shouldCalculateTheAbsoluteDistanceToThePoint() {
        testGame.setPoint(4, 3);
        assertEquals((float) 5, testGame.calculateDistance(), 0.01);
    }

    @Test
    public void findDirection_shouldDetermineDirectionBasedOnPoint() {
        testGame.setPoint(0, 3);
        assertEquals(Directions.NORTH, testGame.findDirection());

        testGame.setPoint(2, 2);
        assertEquals(Directions.NORTH_EAST, testGame.findDirection());

        testGame.setPoint(4, 0);
        assertEquals(Directions.EAST, testGame.findDirection());

        testGame.setPoint(1, -1);
        assertEquals(Directions.SOUTH_EAST, testGame.findDirection());

        testGame.setPoint(0, -5);
        assertEquals(Directions.SOUTH, testGame.findDirection());

        testGame.setPoint(-3, -3);
        assertEquals(Directions.SOUTH_WEST, testGame.findDirection());

        testGame.setPoint(-6, 0);
        assertEquals(Directions.WEST, testGame.findDirection());

        testGame.setPoint(-2, 2);
        assertEquals(Directions.NORTH_WEST, testGame.findDirection());

    }

//	@Test
//	public void testWalkNorth() {
//		int[] testPoint = {4, 3};
//		testGame.walk(testPoint);
//		//walk North
//		assertEquals(3, testPoint[1]);
//	}
//
//	@Test
//	public void testWalkEast() {
//		int[] testPoint = {4, 3};
//		testGame.walk(testPoint);
//		//walk East
//		assertEquals(3, testPoint[0]);
//	}
//
//	@Test
//	public void testWalkSouth() {
//		int[] testPoint = {4, 3};
//		testGame.walk(testPoint);
//		//walk South
//		assertEquals(4, testPoint[1]);
//	}
//
//	@Test
//	public void testWalkWest() {
//		int[] testPoint = {4, 3};
//		testGame.walk(testPoint);
//		//walk West
//		assertEquals(5, testPoint[0]);
//	}
}

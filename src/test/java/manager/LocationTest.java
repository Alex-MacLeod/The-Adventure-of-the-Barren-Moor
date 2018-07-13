package manager;

import game.manager.Location;
import game.util.Directions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationTest {

    @Test
    public void refresh_shouldRefreshWhenTooFarFromOrigin() {
        Location.setLocation(8, 8);
        Location.refresh();
        assertTrue(Location.getXCoord() <= 3 && Location.getYCoord() <= 3);
    }

    @Test
    public void calculateDistance_shouldCalculateTheAbsoluteDistanceToLocation() {
        Location.setLocation(4, 3);
        assertEquals((float) 5, Location.calculateDistance(), 0.01);
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelToLocation() {
        Location.setLocation(0, 3);
        assertEquals(Directions.NORTH, Location.findDirection());

        Location.setLocation(2, 2);
        assertEquals(Directions.NORTH_EAST, Location.findDirection());

        Location.setLocation(4, 0);
        assertEquals(Directions.EAST, Location.findDirection());

        Location.setLocation(1, -1);
        assertEquals(Directions.SOUTH_EAST, Location.findDirection());

        Location.setLocation(0, -5);
        assertEquals(Directions.SOUTH, Location.findDirection());

        Location.setLocation(-3, -3);
        assertEquals(Directions.SOUTH_WEST, Location.findDirection());

        Location.setLocation(-6, 0);
        assertEquals(Directions.WEST, Location.findDirection());

        Location.setLocation(-2, 2);
        assertEquals(Directions.NORTH_WEST, Location.findDirection());

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

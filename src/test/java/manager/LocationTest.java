package manager;

import game.manager.Location;
import game.util.Direction;
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
    public void findDirection_shouldDetermineDirectionOfTravelIsNorth() {
        Location.setLocation(0, 3);
        assertEquals(Direction.NORTH, Location.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsNorthEast() {
        Location.setLocation(2, 2);
        assertEquals(Direction.NORTH_EAST, Location.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsEast() {
        Location.setLocation(4, 0);
        assertEquals(Direction.EAST, Location.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsSouthEast() {
        Location.setLocation(1, -1);
        assertEquals(Direction.SOUTH_EAST, Location.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsSouth() {
        Location.setLocation(0, -5);
        assertEquals(Direction.SOUTH, Location.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsSouthWest() {
        Location.setLocation(-3, -3);
        assertEquals(Direction.SOUTH_WEST, Location.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsWest() {
        Location.setLocation(-6, 0);
        assertEquals(Direction.WEST, Location.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsNorthWest() {
        Location.setLocation(-2, 2);
        assertEquals(Direction.NORTH_WEST, Location.findDirection());
    }

    @Test
    public void findDirection_shouldReturnUnknownIfAtOrigin() {
        Location.setLocation(0, 0);
        assertEquals(Direction.UNKNOWN, Location.findDirection());
    }

	@Test
	public void walk_shouldMovePlayerNorth() {
        Location.setLocation(-2,0);
		Location.walk("north");

		assertEquals(-1, Location.getYCoord());
	}

	@Test
	public void walk_shouldMovePlayerEast() {
        Location.setLocation(4, 3);
        Location.walk("east");

        assertEquals(3, Location.getXCoord());
	}

	@Test
	public void walk_shouldMovePlayerSouth() {
        Location.setLocation(-1,2);
        Location.walk("South");

        assertEquals(3, Location.getYCoord());
	}

	@Test
	public void walk_shouldMovePlayerWest() {
        Location.setLocation(0,1);
        Location.walk("West");

        assertEquals(1, Location.getXCoord());
	}

    @Test
    public void walk_shouldNotMovePlayerIfUnknownDirection() {
        Location.setLocation(2,1);
        Location.walk("behind");

        assertEquals(2, Location.getXCoord());
        assertEquals(1, Location.getYCoord());
    }
}

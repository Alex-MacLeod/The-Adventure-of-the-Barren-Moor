package manager;

import game.manager.Destination;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DestinationTest {

    private Destination testDestination;

    private int originalXCoord;
    private int originalYCoord;

    @Before
    public void setup() {
        testDestination = new Destination();
        originalXCoord = testDestination.getXCoord();
        originalYCoord = testDestination.getYCoord();
    }

    @Test
    public void setDestination_shouldSetDestination() {
        if (originalXCoord == 2 || originalYCoord == 1) {
            testDestination.setDestination(3,4);

            assertEquals(3,testDestination.getXCoord());
            assertEquals(4,testDestination.getYCoord());
        } else {
            testDestination.setDestination(2,1);

            assertEquals(2,testDestination.getXCoord());
            assertEquals(1,testDestination.getYCoord());
        }
    }

    @Test
    public void reset_shouldRefreshWhenTooFarFromOrigin() {
        testDestination.setDestination(8, 8);
        testDestination.reset();

        assertTrue(Math.abs(testDestination.getXCoord()) <= 3 && Math.abs(testDestination.getYCoord()) <= 3);
    }

    @Test
    public void isAtOrigin_shouldReturnTrueIfAtOrigin() {
        testDestination.setDestination(0, 0);

        assertTrue(testDestination.isAtOrigin());
    }

    @Test
    public void isAtOrigin_shouldReturnFalseIfNotAtOrigin() {
        testDestination.setDestination(1, 0);

        assertFalse(testDestination.isAtOrigin());
    }

    @Test
    public void calculateDistance_shouldCalculateTheAbsoluteDistanceToLocation() {
        testDestination.setDestination(4, 3);

        assertEquals((float) 5, testDestination.calculateDistance(), 0.01);
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsNorth() {
        testDestination.setDestination(0, 3);

        assertEquals(Destination.Direction.NORTH, testDestination.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsNorthEast() {
        testDestination.setDestination(2, 2);

        assertEquals(Destination.Direction.NORTH_EAST, testDestination.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsEast() {
        testDestination.setDestination(4, 0);

        assertEquals(Destination.Direction.EAST, testDestination.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsSouthEast() {
        testDestination.setDestination(1, -1);

        assertEquals(Destination.Direction.SOUTH_EAST, testDestination.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsSouth() {
        testDestination.setDestination(0, -5);

        assertEquals(Destination.Direction.SOUTH, testDestination.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsSouthWest() {
        testDestination.setDestination(-3, -3);

        assertEquals(Destination.Direction.SOUTH_WEST, testDestination.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsWest() {
        testDestination.setDestination(-6, 0);

        assertEquals(Destination.Direction.WEST, testDestination.findDirection());
    }

    @Test
    public void findDirection_shouldDetermineDirectionOfTravelIsNorthWest() {
        testDestination.setDestination(-2, 2);

        assertEquals(Destination.Direction.NORTH_WEST, testDestination.findDirection());
    }

    @Test
    public void findDirection_shouldReturnUnknownIfAtOrigin() {
        testDestination.setDestination(0, 0);

        assertEquals(Destination.Direction.UNKNOWN, testDestination.findDirection());
    }

    @Test
    public void walk_shouldMovePlayerNorth() {
        testDestination.walk("north");

        assertEquals(originalYCoord - 1, testDestination.getYCoord());
    }

    @Test
    public void walk_shouldMovePlayerEast() {
        testDestination.walk("east");

        assertEquals(originalXCoord - 1, testDestination.getXCoord());
    }

    @Test
    public void walk_shouldMovePlayerSouth() {
        testDestination.walk("South");

        assertEquals(originalYCoord + 1, testDestination.getYCoord());
    }

    @Test
    public void walk_shouldMovePlayerWest() {
        testDestination.walk("West");

        assertEquals(originalXCoord + 1, testDestination.getXCoord());
    }

    @Test
    public void walk_shouldNotMovePlayerIfUnknownDirection() {
        testDestination.walk("behind");

        assertEquals(originalXCoord, testDestination.getXCoord());
        assertEquals(originalYCoord, testDestination.getYCoord());
    }
}

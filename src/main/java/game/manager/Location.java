package game.manager;

import game.util.Direction;

import java.util.concurrent.ThreadLocalRandom;

public final class Location {

    private static int[] relativeLocation = new int[]{0, 0};

	private Location() {

	}

    public static int getXCoord() {
        return relativeLocation[0];
    }

    public static int getYCoord() {
        return relativeLocation[1];
    }

    public static void setLocation(int xCoord, int yCoord) {
        relativeLocation = new int[]{xCoord, yCoord};
    }

    public static void refresh() {
	    int xPoint;
	    int yPoint;
        do {
            xPoint = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
            yPoint = ThreadLocalRandom.current().nextInt(-2, 2 + 1);
        } while (xPoint == 0 && yPoint == 0);

		relativeLocation[0] = xPoint;
		relativeLocation[1] = yPoint;
	}

	public static boolean isOrigin() {
		return relativeLocation[0] == 0 && relativeLocation[1] == 0;
	}
	
	public static float calculateDistance() {
		return (float) Math.sqrt(Math.pow(relativeLocation[0], 2) + Math.pow(relativeLocation[1], 2));
	}

	public static Direction findDirection() {
	    double angle = Math.atan2(relativeLocation[1], relativeLocation[0]);

		if (Location.isOrigin()) {
		    return Direction.UNKNOWN;
        }

		if (Math.abs(angle) <= Math.PI/8) {
			return Direction.EAST;
		} else if (Math.abs(angle - Math.PI/4) <= Math.PI/8) {
			return Direction.NORTH_EAST;
		} else if (Math.abs(angle - Math.PI/2) <= Math.PI/8) {
			return Direction.NORTH;
		} else if (Math.abs(angle - 3*Math.PI/4) <= Math.PI/8) {
			return Direction.NORTH_WEST;
		} else if (Math.abs(angle + Math.PI/4) <= Math.PI/8) {
			return Direction.SOUTH_EAST;
		} else if (Math.abs(angle + Math.PI/2) <= Math.PI/8) {
			return Direction.SOUTH;
		} else if (Math.abs(angle + 3*Math.PI/4) <= Math.PI/8) {
			return Direction.SOUTH_WEST;
		} else if (Math.abs(angle) >= 7*Math.PI/8) {
			return Direction.WEST;
		} else {
			System.err.println("Direction error, angle is: " + angle);
			return Direction.UNKNOWN;
		}
	}
	
	public static void walk(String direction) {
	    Direction walkingDirection;
	    try {
            walkingDirection = Direction.valueOf(direction.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("You can only walk North, South, East, or West");
            return;
        }

        System.out.println("You walk " + walkingDirection.toLowerCase() + " for one mile.");
        switch (walkingDirection) {
            case NORTH:
                relativeLocation[1]--;
                break;
            case EAST:
                relativeLocation[0]--;
                break;
            case SOUTH:
                relativeLocation[1]++;
                break;
            case WEST:
                relativeLocation[0]++;
                break;
	        default:
        }
	}
}

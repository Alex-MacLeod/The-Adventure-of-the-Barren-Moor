package game.manager;

import game.util.Directions;

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
		return (float) Math.sqrt(relativeLocation[0]^2 + relativeLocation[1]^2);
	}

	public static Enum<Directions> findDirection() {
		double angle = Math.atan2(relativeLocation[1], relativeLocation[0]);
		Directions eventDirection = null;

		if (Math.abs(angle) <= Math.PI/8) {
			eventDirection = Directions.EAST;
		} else if (Math.abs(angle - Math.PI/4) <= Math.PI/8) {
			eventDirection = Directions.NORTH_EAST;
		} else if (Math.abs(angle - Math.PI/2) <= Math.PI/8) {
			eventDirection = Directions.NORTH;
		} else if (Math.abs(angle - 3*Math.PI/4) <= Math.PI/8) {
			eventDirection = Directions.NORTH_WEST;
		} else if (Math.abs(angle + Math.PI/4) <= Math.PI/8) {
			eventDirection = Directions.SOUTH_EAST;
		} else if (Math.abs(angle + Math.PI/2) <= Math.PI/8) {
			eventDirection = Directions.SOUTH;
		} else if (Math.abs(angle + 3*Math.PI/4) <= Math.PI/8) {
			eventDirection = Directions.SOUTH_WEST;
		} else if (Math.abs(angle) >= 7*Math.PI/8) {
			eventDirection = Directions.WEST;
		} else {
			System.err.println("Direction error, angle is: " + angle);
		}
		return eventDirection;
	}
	
	public static void walk(String direction) {
		if ("North".equalsIgnoreCase(direction)) {
			relativeLocation[1]--;
			System.out.println("You walk north for one mile.");
		} else if ("South".equalsIgnoreCase(direction)) {
			relativeLocation[1]++;
			System.out.println("You walk south for one mile.");
		} else if ("East".equalsIgnoreCase(direction)) {
			relativeLocation[0]--;
			System.out.println("You walk east for one mile.");
		} else if ("West".equalsIgnoreCase(direction)) {
			relativeLocation[0]++;
			System.out.println("You walk west for one mile.");
		} else {
			System.out.println("Sorry, which direction?");
		}
	}
}

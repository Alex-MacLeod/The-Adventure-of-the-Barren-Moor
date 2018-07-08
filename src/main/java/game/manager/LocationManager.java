package game.manager;

import game.utils.Directions;
import game.utils.Input;

import java.util.concurrent.ThreadLocalRandom;

public class LocationManager {

	private int[] location;

	public LocationManager() {
		this.location = new int[]{0, 0};
	}

    public int getXCoord() {
        return this.location[0];
    }

    public int getYCoord() {
        return this.location[1];
    }

    public void setLocation(int xCoord, int yCoord) {
        this.location = new int[]{xCoord, yCoord};
    }

    public void refresh() {
	    int xPoint;
	    int yPoint;
        do {
            xPoint = ThreadLocalRandom.current().nextInt(-3, 3 + 1);
            yPoint = ThreadLocalRandom.current().nextInt(-3, 3 + 1);
        } while (xPoint == 0 && yPoint == 0);

		this.location[0] = xPoint;
		this.location[1] = yPoint;
	}

	public boolean isOrigin() {
		return location[0] == 0 && location[1] == 0;
	}
	
	public float calculateDistance() {
		return (float) Math.sqrt((double)this.location[0]*this.location[0] + (double)this.location[1]*this.location[1]);
	}

	public Enum<Directions> findDirection() {
		double angle = Math.atan2(this.location[1], this.location[0]);
		Directions eventDirection = null;
		if (angle <= Math.PI/8 && angle > -Math.PI/8) {
			eventDirection = Directions.EAST;
		} else if (angle <= 3*Math.PI/8 && angle > Math.PI/8) {
			eventDirection = Directions.NORTH_EAST;
		} else if (angle <= 5*Math.PI/8 && angle > 3*Math.PI/8) {
			eventDirection = Directions.NORTH;
		} else if (angle <= 7*Math.PI/8 && angle > 5*Math.PI/8) {
			eventDirection = Directions.NORTH_WEST;
		} else if (angle <= -7*Math.PI/8 || angle > 7*Math.PI/8) {
			eventDirection = Directions.WEST;
		} else if (angle <= -5*Math.PI/8 && angle > -7*Math.PI/8) {
			eventDirection = Directions.SOUTH_WEST;
		} else if (angle <= -3*Math.PI/8 && angle > -5*Math.PI/8) {
			eventDirection = Directions.SOUTH;
		} else if (angle <= -Math.PI/8 && angle > -3*Math.PI/8) {
			eventDirection = Directions.SOUTH_EAST;
		} else {
			System.err.println("Error");
		}
		return eventDirection;
	}
	
	public void walk() {
		System.out.println("Do you want to go North, South, East, or West?");
		String direction = Input.scan.next();
		if ("North".equalsIgnoreCase(direction)) {
			this.location[1]--;
			System.out.println("You walk north for one mile.");
		} else if ("South".equalsIgnoreCase(direction)) {
			this.location[1]++;
			System.out.println("You walk south for one mile.");
		} else if ("East".equalsIgnoreCase(direction)) {
			this.location[0]--;
			System.out.println("You walk east for one mile.");
		} else if ("West".equalsIgnoreCase(direction)) {
			this.location[0]++;
			System.out.println("You walk west for one mile.");
		} else {
			System.out.println("Sorry, which direction?");
		}
	}

	public void checkCompass() {
        System.out.println("The compass is pointing " + findDirection() + ".");
        System.out.println("The display reads: " + calculateDistance() + " miles.");
    }
}

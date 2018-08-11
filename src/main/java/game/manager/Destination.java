package game.manager;

import java.util.concurrent.ThreadLocalRandom;

public final class Destination {

    private static final int RESET_BOUND = 2;
    private int[] relativeLocation = new int[]{0, 0};

	public Destination() {
		this.reset();
	}

    public int getXCoord() {
        return this.relativeLocation[0];
    }

    public int getYCoord() {
        return this.relativeLocation[1];
    }

    public void setDestination(int xCoord, int yCoord) {
        this.relativeLocation[0] = xCoord;
        this.relativeLocation[1] = yCoord;
    }

    public void reset() {
	    int xPoint;
	    int yPoint;
        do {
            xPoint = ThreadLocalRandom.current().nextInt(-RESET_BOUND, RESET_BOUND + 1);
            yPoint = ThreadLocalRandom.current().nextInt(-RESET_BOUND, RESET_BOUND + 1);
        } while (xPoint == 0 && yPoint == 0);

		this.setDestination(xPoint, yPoint);
	}

	public boolean isAtOrigin() {
		return this.relativeLocation[0] == 0 && this.relativeLocation[1] == 0;
	}
	
	public float calculateDistance() {
		return (float) Math.sqrt(Math.pow(this.relativeLocation[0], 2) + Math.pow(this.relativeLocation[1], 2));
	}

    public enum Direction {
        NORTH("north"), NORTH_EAST("north-east"), EAST("east"), SOUTH_EAST("south-east"), SOUTH("south"),
        SOUTH_WEST("south-west"), WEST("west"), NORTH_WEST("north-west"), UNKNOWN("towards a nearby object");

        private String lowerCase;

        Direction(String lowerCase) {
            this.lowerCase = lowerCase;
        }

        public String toLowerCase() {
            return this.lowerCase;
        }
    }

	public Direction findDirection() {
	    double angle = Math.atan2(this.relativeLocation[1], this.relativeLocation[0]);
		if (this.isAtOrigin()) {
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

    public void walk(String direction) {
        Direction walkingDirection;
        try {
            walkingDirection = Direction.valueOf(direction.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("You can only walk North, South, East, or West");
            return;
        }
        switch (walkingDirection) {
            case NORTH:
                this.relativeLocation[1]--;
                break;
            case EAST:
                this.relativeLocation[0]--;
                break;
            case SOUTH:
                this.relativeLocation[1]++;
                break;
            case WEST:
                this.relativeLocation[0]++;
                break;
            default:
                System.out.println("You can only walk North, South, East, or West");
                return;
        }
        System.out.println("You walk " + walkingDirection.toLowerCase() + " for one mile.");
    }
}

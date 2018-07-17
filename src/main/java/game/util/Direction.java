package game.util;

public enum Direction {
	NORTH("north"),
	NORTH_EAST("north-east"),
	EAST("east"),
	SOUTH_EAST("south-east"),
	SOUTH("south"),
	SOUTH_WEST("south-west"),
	WEST("west"),
	NORTH_WEST("north-west"),
	UNKNOWN("towards a nearby object");

	private String lowerCase;

	Direction(String lowerCase) {
		this.lowerCase = lowerCase;
	}

	public String toLowerCase() {
		return this.lowerCase;
	}
}
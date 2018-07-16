package game.util;

public enum Directions {
	NORTH("north"),
	NORTH_EAST("north-east"),
	EAST("east"),
	SOUTH_EAST("south-east"),
	SOUTH("south"),
	SOUTH_WEST("south-west"),
	WEST("west"),
	NORTH_WEST("north-west"),
	UNKNOWN("towards a nearby object");

	private String lowercase;

	Directions(String lowercase) {
		this.lowercase = lowercase;
	}

	public String getLowercase() {
		return this.lowercase;
	}
}
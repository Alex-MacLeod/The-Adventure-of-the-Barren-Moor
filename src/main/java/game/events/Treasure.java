package game.events;

public class Treasure extends Event{

	public Treasure(int value) {
		super(value);
	}

	public void playEvent() {
		System.out.println("You have found a great oak chest filled with treasure!");
	}
}

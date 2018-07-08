package game.events;

public class Treasure extends Event{

	public Treasure(int value) {
		super(value);
	}

	@Override
	public void playEvent() {
		System.out.println("You have found a great oak chest filled with treasure!");
		super.playEvent();
	}
}

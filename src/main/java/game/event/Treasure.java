package game.event;

public class Treasure extends Event{

	public Treasure(int value) {
		super(value);
	}

	@Override
	public void play() {
		System.out.println("You have found a great oak chest filled with treasure!");
		super.play();
	}
}

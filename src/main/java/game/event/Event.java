package game.event;

public abstract class Event {
	private final int value;
	private boolean completed;

	Event(int value) {
		this.value = value;
		this.completed = false;
	}

	Event() {
		this.value = 0;
		this.completed = false;
	}

	public int getValue() {
		return value;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void play() {
		this.completed = true;
	}

}

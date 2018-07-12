package game.events;

public abstract class Event {
	private int value;
	private boolean completed;

	Event(int value) {
		this.value = value;
		this.completed = false;
	}

	public int getValue() {
		return value;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void playEvent() {
		this.completed = true;
	}

}

package game.event;

abstract class Treasure implements Event{

    private int value;
    private boolean plundered;

	Treasure(int value) {
		this.value = value;
		this.plundered = false;
	}

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public boolean isCompleted() {
        return this.plundered;
    }

    @Override
    public void play() {
	    System.out.println("You take the treasure from the chest");
	    this.plundered = true;
        System.out.println("You're one step closer to leaving the moor!");
    }
}

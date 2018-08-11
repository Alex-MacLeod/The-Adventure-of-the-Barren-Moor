package game.event;

abstract class Treasure implements Event{

    private int value;
    private boolean opened;

	Treasure(int value) {
		this.value = value;
        this.opened = false;
	}

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public boolean isCompleted() {
        return this.opened;
    }

    @Override
    public void play() {
        this.opened = true;
	    System.out.println("You take the treasure from the chest");
        System.out.println("You're one step closer to leaving the moor!");
    }
}

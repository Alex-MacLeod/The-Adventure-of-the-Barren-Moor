package game.event;

abstract class Treasure implements Event{

    private int value;

	Treasure(int value) {
		this.value = value;
	}

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public boolean isCompleted() {
        return true;
    }

    @Override
    public void play() {
	    System.out.println("You take the treasure from the chest");
        System.out.println("You're one step closer to leaving the moor!");
    }
}

package game.event;

public class SmallTreasure extends Treasure{

    private static final int SMALL_TREASURE_VALUE = 2500;

    public SmallTreasure() {
        super(SMALL_TREASURE_VALUE);
    }

    @Override
    public void play() {
        System.out.println("You have found a small wooden chest filled with treasure!");
        super.play();
    }
}

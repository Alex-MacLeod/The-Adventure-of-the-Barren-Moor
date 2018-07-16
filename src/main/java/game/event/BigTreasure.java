package game.event;

public class BigTreasure extends Treasure{

    private static final int BIG_TREASURE = 5000;

    public BigTreasure() {
        super(BIG_TREASURE);
    }

    @Override
    public void play() {
        System.out.println("You have found a great oak chest brimming with with treasure!");
        super.play();
    }
}

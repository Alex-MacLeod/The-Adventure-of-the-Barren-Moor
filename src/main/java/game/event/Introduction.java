package game.event;

public class Introduction extends Event {

    @Override
    public void play() {
        System.out.println("You awaken to find yourself alone, lying cold and wet on a barren moor.");
        System.out.println("Slowly, you pick yourself up from the ground and take in your bleak surroundings.");
        System.out.println("All around, you are surrounded by a thick grey fog. You cannot see much around you.");
        System.out.println("You can just about see a black weathered rock in front of you, struggling against"
                + " being swallowed up by the fog.");
        System.out.println("You feel something strange in your pocket.");

        System.out.println("You take it out and examine it.");
        System.out.println("It looks a bit like a pocket watch. However, there is only one hand, "
                + "and it has a small display.");
        System.out.println("The markings on it suggest that it might be a compass, but it definitely doesn't point north.");
        System.out.println("The display seems to show a distance. Is this device pointing you towards something?");
        super.play();
    }
}
